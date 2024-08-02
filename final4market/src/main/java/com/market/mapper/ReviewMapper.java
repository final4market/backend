package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.MemberDTO;
import com.market.dto.ReviewDTO;

@Mapper
public interface ReviewMapper {
	List<ReviewDTO> selectAllReview();

	int insertReview(ReviewDTO dto);

	List<MemberDTO> productWroteList(String memberId);

	List<MemberDTO> wroteReviewList(int productNo);

	int reviewDelete(int productNo);

	int updateReview(ReviewDTO dto);
}