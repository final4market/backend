package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.ProductDTO;

@Mapper
public interface ProductMapper {
	List<ProductDTO> selectAllProduct();
}