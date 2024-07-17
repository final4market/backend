package com._market.demo.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("review")
public class ReviewDTO {
	private int productNo;
	private String buyerId;
	private String review;
	private String sellerId;
	private Date reviewDate;
	private int reviewScore;

	public ReviewDTO() {
	}

	public ReviewDTO(int productNo, String buyerId, String review, String sellerId, Date reviewDate, int reviewScore) {
		super();
		this.productNo = productNo;
		this.buyerId = buyerId;
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

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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
		return "ReviewDTO [productNo=" + productNo + ", buyerId=" + buyerId + ", review=" + review + ", sellerId="
				+ sellerId + ", reviewDate=" + reviewDate + ", reviewScore=" + reviewScore + "]";
	}
}