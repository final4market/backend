package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.dto.CategoryDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.mapper.ProductMapper;


@Service
public class ProductService {
	ProductMapper mapper;

	public ProductService(ProductMapper mapper) {
		this.mapper = mapper;
	}

	public List<ProductImageDTO> productImage(int productNo) {
		return mapper.productImage(productNo);
	}

	public ProductDTO productInfo(int productNo) {
		return mapper.productInfo(productNo);
	}

	public DeliveryDTO deliveryInfo(int productNo) {
		return mapper.deliveryInfo(productNo);
	}

	public List<CategoryDTO> categoryInfo(int categoryNo) {
		return mapper.categoryInfo(categoryNo);
	}
}
