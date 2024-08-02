package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.dto.MemberDTO;
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

	public int insertReview(ReviewDTO dto) {
		return mapper.insertReview(dto);
		
	}

	public List<MemberDTO> productWroteList(String memberId) {
		return mapper.productWroteList(memberId) ;
	}

	public List<MemberDTO> wroteReviewList(int productNo) {
		return mapper.wroteReviewList(productNo) ;
	}

	public int reviewDelete(int productNo) {
		return mapper.reviewDelete(productNo) ;
	}

	public int updateReview(ReviewDTO dto) {
		return mapper.updateReview(dto);
		
	}
}