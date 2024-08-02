package com.market.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.market.dto.CategoryDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.service.ProductService;


import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin(origins = "http://localhost:3000" , allowedHeaders = "*" )
public class ProductController {
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/api/product/productImage")
	public List<ProductImageDTO> productImage(int productNo) {
		List<ProductImageDTO> list = productService.productImage(productNo);
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/api/product/productInfo")
	public ProductDTO productInfo(int productNo) {
		ProductDTO dto = productService.productInfo(productNo);
		return dto; 
	}
	
	@GetMapping("/api/product/deliveryInfo")
	public DeliveryDTO deliveryInfo(int productNo) {
		DeliveryDTO dto = productService.deliveryInfo(productNo);
		System.out.println(dto);
		return dto; 
	}
	
	@GetMapping("/api/product/categoryInfo")
	public List<CategoryDTO> categoryInfo(int categoryNo) {
		List<CategoryDTO> list = productService.categoryInfo(categoryNo);
		return list; 
	}
	
	@GetMapping("/api/product/newproductlist")
	public List<ProductDTO> newproductlist() {
	return productService.newproductlist();
	}
	
	@GetMapping("/api/product/hotproductlist")
	public List<ProductDTO> hotproductlist() {
	return productService.hotproductlist();
	}
	
	@GetMapping("/api/product/category/list")
	public List<CategoryDTO> selectAllCategory() {
		return productService.selectAllCategory();
	}

	@GetMapping("/api/product/category/list/{parNum}")
	public List<CategoryDTO> selectParentCategory(@PathVariable int parNum) {
		return productService.selectParentCategory(parNum);
	}
	
	
	@GetMapping("/api/product/update/view/{productNo}")
	public ProductDTO productUpdate(@PathVariable int productNo ) {
	    return productService.productUpdate(productNo);
	   
	}
	

	@PostMapping("/product/insert")
	public Map<String, Object> insertProduct(@RequestParam Map<String, String> params,
	                                         @RequestParam(value = "imageKey0", required = false) String imageKey0,
	                                         @RequestParam(value = "imageKey1", required = false) String imageKey1,
	                                         @RequestParam(value = "imageKey2", required = false) String imageKey2) throws NumberFormatException {

	    Map<String, Object> map = new HashMap<>();
	    try {
	        ProductDTO dto = new ProductDTO();
	        dto.setProductTitle(params.get("productTitle"));
	        dto.setProductPrice(Integer.parseInt(params.get("productPrice")));
	        dto.setCategoryNo(Integer.parseInt(params.get("categoryNo")));
	        dto.setProductContent(params.get("productContent"));
	        dto.setProductStatus(params.get("productStatus"));
	        dto.setMemberId(params.get("memberId"));

	       
	        
	        // deliveryCharge 값이 null일 경우를 처리

	        String deliveryChargeStr = params.get("deliveryCharge");
	        dto.setDeliveryCharge(deliveryChargeStr != null && !deliveryChargeStr.isEmpty() ? Integer.parseInt(deliveryChargeStr) : 0);

	        String deliveryNoStr = params.get("deliveryNo");
	        if (deliveryNoStr != null && !deliveryNoStr.isEmpty()) {
	            dto.setDeliveryNo(Integer.parseInt(deliveryNoStr));
	        } else {
	            dto.setDeliveryNo(0);
	        }

	        String tradeArea = params.get("tradeArea");
	        if (tradeArea != null && !tradeArea.isEmpty()) {
	            dto.setTradeArea(tradeArea);
	        } else {
	            dto.setTradeArea("0");
	        }

	        int productNo = productService.getProductNo();
	        dto.setProductNo(productNo);

	        productService.insertProduct(dto);

	        // Save images with numbering
	        List<String> imageKeys = Arrays.asList(imageKey0, imageKey1, imageKey2).stream()
                    .filter(key -> key != null && !key.isEmpty())
                    .collect(Collectors.toList());
	        System.out.println(imageKeys);

	        
	        productService.saveProductImages(productNo, imageKeys);

	        map.put("msg", "상품 등록 성공");
	        map.put("result", true);
	        map.put("productNo", productNo);
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	        map.put("msg", "입력 값 오류 다시 입력해 주세요: " + e.getMessage());
	        map.put("result", false);
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put("msg", "상품 등록 실패");
	        map.put("result", false);
	    }
	    return map;
	}


//	@PostMapping("/product/update/{productNo}")
//	public Map<String, Object> updateProduct(@RequestParam Map<String, String> params,@PathVariable int productNo,
//	                                          @RequestParam("file") MultipartFile[] file) throws NumberFormatException {
//	    Map<String, Object> map = new HashMap<>();
//	    try {
//	        ProductDTO dto = new ProductDTO();
//	        dto.setProductTitle(params.get("productTitle"));
//	        dto.setProductPrice(Integer.parseInt(params.get("productPrice")));
//	        dto.setCategoryNo(Integer.parseInt(params.get("categoryNo")));
//	        dto.setProductContent(params.get("productContent"));
//	        dto.setProductStatus(params.get("productStatus"));
//	        dto.setMemberId(params.get("memberId"));
//	       
//	        
//	        // deliveryCharge 값이 null일 경우를 처리
//	        String deliveryChargeStr = params.get("deliveryCharge");
//	        dto.setDeliveryCharge(deliveryChargeStr != null && !deliveryChargeStr.isEmpty() ? Integer.parseInt(deliveryChargeStr) : 0);
//	        
//	        String deliveryNoStr = params.get("deliveryNo");
//	        if (deliveryNoStr != null && !deliveryNoStr.isEmpty()) {
//	            dto.setDeliveryNo(Integer.parseInt(deliveryNoStr));
//	        } else {
//	            dto.setDeliveryNo(0);
//	        }
//	        
//	        String tradeArea = params.get("tradeArea");
//	        if (tradeArea != null && !tradeArea.isEmpty()) {
//	            dto.setTradeArea(tradeArea);
//	        } else {
//	            dto.setTradeArea("0"); // 기본값 설정
//	        }
//	        
//	        dto.setProductNo(productNo);
//	        
//	        productService.updateProduct(dto);
//	        
//	        File root = new File("c:\\fileupload");
//	        if (!root.exists()) {
//	            root.mkdirs();
//	        }
//	        
//	        for (int i = 0; i < file.length; i++) {
//	            if (file[i].getSize() == 0) {
//	                continue;
//	            }
//	            File f = new File(root, file[i].getOriginalFilename());
//	            file[i].transferTo(f);
////	            ProductImageDTO productImageDTO = new ProductImageDTO(i, productNo, f);
////	            productService.updateProductImage(productImageDTO);
//	        }
//	        
//	        map.put("msg", "상품 등록 성공");
//	        map.put("result", true);
//	    } catch (IllegalArgumentException e) {
//	        e.printStackTrace();
//	        map.put("msg", "입력 값 오류 다시입력해세요: " + e.getMessage());
//	        map.put("result", false);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        map.put("msg", "상품 등록 실패");
//	        map.put("result", false);
//	    }
//	    return map;
//	}
	
	
	@GetMapping("/api/product/category/parent/{categoryNumber}")
	public int parentCategory(@PathVariable int categoryNumber) {
		return  productService.parentCategory(categoryNumber);
	}
	


	/*
	 * @PostMapping("/product/insert") public Map<String, Object>
	 * insertProduct2(@RequestParam Map<String, String> params,
	 * 
	 * @RequestParam("file") MultipartFile[] file) throws NumberFormatException {
	 * Map<String, Object> map = new HashMap<>(); try { ProductDTO dto = new
	 * ProductDTO(); dto.setProductTitle(params.get("productTitle"));
	 * dto.setProductPrice(Integer.parseInt(params.get("productPrice")));
	 * dto.setCategoryNo(Integer.parseInt(params.get("categoryNo")));
	 * dto.setProductContent(params.get("productContent"));
	 * dto.setProductStatus(params.get("productStatus"));
	 * 
	 * 
	 * // deliveryCharge 값이 null일 경우를 처리 String deliveryChargeStr =
	 * params.get("deliveryCharge"); dto.setDeliveryCharge(deliveryChargeStr != null
	 * && !deliveryChargeStr.isEmpty() ? Integer.parseInt(deliveryChargeStr) : 0);
	 * 
	 * String deliveryNoStr = params.get("deliveryNo"); if (deliveryNoStr != null &&
	 * !deliveryNoStr.isEmpty()) {
	 * dto.setDeliveryNo(Integer.parseInt(deliveryNoStr)); } else {
	 * dto.setDeliveryNo(0); }
	 * 
	 * String tradeArea = params.get("tradeArea"); if (tradeArea != null &&
	 * !tradeArea.isEmpty()) { dto.setTradeArea(tradeArea); } else {
	 * dto.setTradeArea("0"); // 기본값 설정 }
	 * 
	 * int productNo = productService.getProductNo(); dto.setProductNo(productNo);
	 * 
	 * productService.insertProduct(dto);
	 * 
	 * File root = new File("c:\\fileupload"); if (!root.exists()) { root.mkdirs();
	 * }
	 * 
	 * for (int i = 0; i < file.length; i++) { if (file[i].getSize() == 0) {
	 * continue; } File f = new File(root, file[i].getOriginalFilename());
	 * file[i].transferTo(f); ProductImageDTO productImageDTO = new
	 * ProductImageDTO(f, productNo);
	 * productService.insertProductImage(productImageDTO); }
	 * 
	 * map.put("msg", "상품 등록 성공"); map.put("result", true); } catch
	 * (IllegalArgumentException e) { e.printStackTrace(); map.put("msg",
	 * "입력 값 오류 다시입력해세요: " + e.getMessage()); map.put("result", false); } catch
	 * (Exception e) { e.printStackTrace(); map.put("msg", "상품 등록 실패");
	 * map.put("result", false); } return map; }
	 */


	@GetMapping("/api/product/sellerProductImage")
	public List<Map<String, Object>> sellerProductImage(String memberId) {
	    List<String> productNoList = productService.productNo(memberId);
	    List<Map<String, Object>> productImages = new ArrayList<>();
	    
	    for (String productNo : productNoList) {
	        List<String> images = productService.sellerProductImage(productNo); // productService에 제품 번호에 해당하는 이미지 목록을 가져오는 메서드를 정의해야 함
	        ProductDTO dto = productService.sellerProductPrice(productNo);
	        if (!images.isEmpty()) {
	            String firstImage = images.get(0); // 각 제품의 첫 번째 이미지만 가져옴
	            
	            Map<String, Object> imageMap = new HashMap<>();
	            imageMap.put("productNo", productNo);
	            imageMap.put("image", firstImage);
	            imageMap.put("price", dto.getProductPrice());
	            imageMap.put("title", dto.getProductTitle());
	            
	            productImages.add(imageMap);
	        }
	    }
	    
	    return productImages;
	}
		
	
	@GetMapping("/file")
	public void fileDown(int productNo, int productImageNo, HttpServletResponse response) throws IOException {
	    //파일 정보 읽어옴
		ProductImageDTO dto = productService.selectFile(productNo,productImageNo);
	    System.out.println(dto);
	    //출력 스트림 연결 데이터 전송
	    File file = new File(dto.getProductImagePath());
	    
	    response.setHeader("Content-Disposition", "attachement;fileName="+dto.getProductImagePath());
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.setContentLength((int)file.length());
	    
	    FileInputStream fis = new FileInputStream(file);
	    BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	    
	    byte[] buffer = new byte[1024*1024];
	    
	    while(true) {
	        int size = fis.read(buffer);
	        if(size == -1) break;
	        bos.write(buffer, 0, size);
	        bos.flush();
	    }
	    
	    bos.close();
	    fis.close();
	}

	@GetMapping("/insertProductLike")
	public Map<String, Object> productLike(String memberId, int productNo) {
		Map<String, Object> map = new HashMap<>();
		try {			
			productService.insertProductLike(memberId, productNo);
			map.put("msg", "좋아요를 하셨습니다");
		} catch (Exception e) {
			productService.deleteProductLike(memberId, productNo);
			map.put("msg", "좋아요를 취소하셨습니다");
			return map;
		}
		
		
		return map;
	}
	
	
	@GetMapping("/api/product/selectLikeStatus")
	public List<String> selectLikeStatus(int productNo) {
		List<String> list = productService.selectLikeStatus(productNo);
		return list;
	}
	
	@PutMapping("/updateProductSaleSatus")
	public Map<String, Object> updateProductSaleSatus(int productNo){
		System.out.println(productNo);
		Map<String, Object> map = new HashMap<>();
		try {
			productService.updateProductSaleSatus(productNo);
			map.put("msg", "결제 완료되었습니다");
		} catch (Exception e) {
			map.put("msg", "결제 실패했습니다");
		}
		return map;
	}
	
	@GetMapping("/api/product/categoryProductInfo")
	public List<ProductDTO> categoryProductInfo(int categoryNo){
		
		List<ProductDTO> list = productService.categoryProductInfo(categoryNo);
		
		return list;
	}
	
	@PostMapping("/api/product/categoryProductImg")
	public List<ProductImageDTO> categoryProductImg(@RequestBody Map<String, Object> productNo){
		System.out.println(productNo);
		List<String> productNos = (List<String>) productNo.get("productNo");
		System.out.println(productNos);
		List<ProductImageDTO> list = productService.categoryProductImg(productNos);
		return list;
	}
	
	@PostMapping("/insertTransaction")
	public void updateTransaction(int productNo, String memberId) {
		System.out.println(productNo);
		productService.insertTransaction(productNo, memberId);
	}

}
