package com._market.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com._market.demo.dto.ReviewDTO;

@Mapper
public interface ReviewMapper {
	List<ReviewDTO> selectAllReview();
}