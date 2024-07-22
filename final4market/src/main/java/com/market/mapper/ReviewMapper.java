package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.ReviewDTO;

@Mapper
public interface ReviewMapper {
	List<ReviewDTO> selectAllReview();

	int insertReview(ReviewDTO dto);
}