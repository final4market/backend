package com._market.demo.service;

import org.springframework.stereotype.Service;

import com._market.demo.mapper.ProductMapper;

@Service
public class ProductService {
	private ProductMapper mapper;
	
	public ProductService(ProductMapper mapper) {
		this.mapper = mapper;
	}

	public String selectAllMypage() {
		return mapper.selectAllMypage();
	}

}