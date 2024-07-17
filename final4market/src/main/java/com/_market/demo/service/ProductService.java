package com._market.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com._market.demo.dto.ProductDTO;
import com._market.demo.mapper.ProductMapper;

@Service
public class ProductService {
	private ProductMapper mapper;

	public ProductService(ProductMapper mapper) {
		this.mapper = mapper;
	}

	public List<ProductDTO> selectAllProduct() {
		return mapper.selectAllProduct();
	}
}