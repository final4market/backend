package com.market.dto;

import java.sql.Date;

public class MyPageReceivedReviewDTO {
	private int productNo;
	private String memberId;
	private String review;
	private String sellerId;
	private Date reviewDate;
	private int reviewScore;

	public MyPageReceivedReviewDTO() {
	}

	public MyPageReceivedReviewDTO(int productNo, String memberId, String review, String sellerId, Date reviewDate,
			int reviewScore) {
		this.productNo = productNo;
		this.memberId = memberId;
		this.review = review;
		this.sellerId = sellerId;
		this.reviewDate = reviewDate;
		this.reviewScore = reviewScore;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	@Override
	public String toString() {
		return "MyPageReceivedReviewDTO [productNo=" + productNo + ", memberId=" + memberId + ", review=" + review
				+ ", sellerId=" + sellerId + ", reviewDate=" + reviewDate + ", reviewScore=" + reviewScore + "]";
	}
}