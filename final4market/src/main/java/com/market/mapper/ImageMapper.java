package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.ImageDTO;

@Mapper
public interface ImageMapper {
	List<ImageDTO> selectAllImage();
}