package com.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dto.ProductImageDTO;
import com.market.models.ProductImage;
import com.market.models.Product;
import com.market.mapper.ImageMapper;

@Service
public class ImageService {

	@Autowired
    private ImageMapper imageMapper;

    //상품 이미지 정보 DB에 저장
	 public void saveProductImageInfo(ProductImageDTO productImageDTO) {
	        ProductImage productImage = new ProductImage();
	        productImage.setProductNo(productImageDTO.getProductNo());
	        productImage.setProductImagePath(productImageDTO.getProductImagePath());
	        imageMapper.insertProductImage(productImage);
	    }
    
    // 해당 이미지에 대한 삭제 권한이 있는지 확인
	 public boolean isAuthorizedToDeleteProductImage(String memberId, int productNo, int productImageNo) {
	        Product product = imageMapper.findProductById(productNo);
	        if (product == null || !product.getMemberId().equals(memberId)) {
	            return false;
	        }

	        ProductImage productImage = imageMapper.findProductImageById(productImageNo);
	        return productImage != null && productImage.getProductNo() == productNo;
	    }
    
	 public String getObjectKeyByProductImageNo(int productImageNo) {
	        ProductImage productImage = imageMapper.findProductImageById(productImageNo);
	        return productImage != null ? productImage.getProductImagePath() : null;
	    }

	 public void deleteProductImageDetails(int productImageNo) {
	        imageMapper.deleteProductImage(productImageNo);
	    }
}
