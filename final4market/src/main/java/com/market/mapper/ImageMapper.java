package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.ProductImageDTO;


@Mapper
public interface ImageMapper {
	List<ProductImageDTO> selectAllImage();
}