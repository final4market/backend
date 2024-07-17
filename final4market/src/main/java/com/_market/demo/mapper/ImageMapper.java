package com._market.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com._market.demo.dto.ImageDTO;

@Mapper
public interface ImageMapper {
	List<ImageDTO> selectAllImage();
}