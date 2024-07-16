package com._market.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com._market.demo.dto.CategoryDTO;
import com._market.demo.dto.ProductDTO;
import com._market.demo.dto.ProductImageDTO;
import com._market.demo.mapper.ProductMapper;

@Service
public class ProductService {
	private ProductMapper mapper;
		
	public ProductService(ProductMapper mapper)
	{
		this.mapper = mapper;
	}

	public List<ProductDTO> selectAllProduct() {
		return mapper.selectAllProduct();
	}

	public List<CategoryDTO> selectAllCategory() {
		return mapper.selectAllCategory();
	}

	public int insertProduct(ProductDTO dto) {
		return mapper.insertProduct(dto);
	}

	public int getProductNo() {
		return mapper.getProductNo();
	}

	public List<CategoryDTO> selectParentCategory(int parNum) {
		return mapper.selectParentCategory(parNum);
	}

	public int insertProductImage(ProductImageDTO productImageDTO) {
		return mapper.insertProductImage(productImageDTO);
		
	}



  
}


