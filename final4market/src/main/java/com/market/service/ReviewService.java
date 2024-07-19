package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.dto.ReviewDTO;
import com.market.mapper.ReviewMapper;

@Service
public class ReviewService {
	private ReviewMapper mapper;

	public ReviewService(ReviewMapper mapper) {
		this.mapper = mapper;
	}

	public List<ReviewDTO> selectAllReview() {
		return mapper.selectAllReview();
	}
}