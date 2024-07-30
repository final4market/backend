package com.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.market.dto.ProductImageDTO;
import com.market.service.ImageService;
import com.market.service.S3Service;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/images/productImg")
public class ProductImgController {

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadProductImg(@RequestParam("file") MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String memberId = authentication.getName();
        
        System.out.println("Authenticated user: " + memberId);
        System.out.println("Roles: " + authentication.getAuthorities());

        // PUT 작업을 위한 임시 pre-signed URL 생성
        String objectKey = generateTemporaryObjectKey(memberId, file.getOriginalFilename());
        URL preSignedUrl;
        try {
            preSignedUrl = s3Service.generatePresignedUrl("lucky4market-imgsrvr", objectKey, convertToAwsHttpMethod(HttpMethod.PUT));
            System.out.println("Generated preSignedUrl: " + preSignedUrl);
        } catch (Exception e) {
            System.err.println("Error generating pre-signed URL: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // object key 임시 저장
        Map<String, String> response = new HashMap<>();
        response.put("preSignedUrl", preSignedUrl.toString());
        response.put("objectKey", objectKey);
        System.out.println("리턴된 objectKey: " + objectKey);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{productNo}/{productImageNo}")
    public ResponseEntity<String> deleteProductImage(@PathVariable("productNo") int productNo,
            @PathVariable("productImageNo") int productImageNo) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String memberId = authentication.getName();


        // 회원에게 해당 이미지에 대한 삭제 권한이 있는지 확인
        if (!imageService.isAuthorizedToDeleteProductImage(memberId, productNo, productImageNo)) {
            return new ResponseEntity<>("삭제 권한이 없습니다", HttpStatus.FORBIDDEN);
        }
        //AWS S3 서버에서 해당 이미지를 찾아 삭제
        String objectKey = imageService.getObjectKeyByProductImageNo(productImageNo);
        try {
            s3Service.deleteObject("lucky4market-imgsrvr", objectKey);
        } catch (Exception e) {
            return new ResponseEntity<>("AWS S3에서 삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // DB에서 해당 이미지 관련 정보 삭제
        imageService.deleteProductImageDetails(productImageNo);

        return new ResponseEntity<>("삭제가 완료되었습니다", HttpStatus.OK);
    }

    private String generateTemporaryObjectKey(String memberId, String filename) {
        return "temp/" + memberId + "/" + filename;
    }
    
    private com.amazonaws.HttpMethod convertToAwsHttpMethod(HttpMethod springHttpMethod) {
        return com.amazonaws.HttpMethod.valueOf(springHttpMethod.name());
    }
}
