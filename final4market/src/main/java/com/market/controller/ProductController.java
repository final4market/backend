package com.market.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.CategoryDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*" )
public class ProductController {
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/productImage")
	public List<ProductImageDTO> productImage(int productNo) {
		List<ProductImageDTO> list = productService.productImage(productNo);
		return list;
	}
	
	@GetMapping("/productInfo")
	public ProductDTO productInfo(int productNo) {
		ProductDTO dto = productService.productInfo(productNo);
		return dto; 
	}
	
	@GetMapping("/deliveryInfo")
	public DeliveryDTO deliveryInfo(int productNo) {
		DeliveryDTO dto = productService.deliveryInfo(productNo);
		return dto; 
	}
	
	@GetMapping("/categoryInfo")
	public List<CategoryDTO> categoryInfo(int categoryNo) {
		List<CategoryDTO> list = productService.categoryInfo(categoryNo);
		return list; 
	}
	
}
