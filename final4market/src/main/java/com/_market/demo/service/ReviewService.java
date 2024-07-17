package com._market.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com._market.demo.dto.ReviewDTO;
import com._market.demo.mapper.ReviewMapper;

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