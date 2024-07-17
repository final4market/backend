package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.dto.ProductDTO;
import com.market.mapper.ProductMapper;

@Service
public class ProductService {
	private ProductMapper mapper;

	public ProductService(ProductMapper mapper) {
		this.mapper = mapper;
	}

	public List<ProductDTO> selectAllProduct() {
		return mapper.selectAllProduct();
	}

	public String selectAllMypage() {
		return null;
	}
}