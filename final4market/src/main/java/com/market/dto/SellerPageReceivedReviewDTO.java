package com.market.dto;

import java.sql.Date;

public class SellerPageReceivedReviewDTO {
	private int productNo;
	private String productImagePath;
	private String productTitle;
	private int productPrice;
	private String buyerId;
	private String buyerNick;
	private Date reviewDate;
	private int reviewScore;
	private String review;

	public SellerPageReceivedReviewDTO() {
	}

	public SellerPageReceivedReviewDTO(int productNo, String productImagePath, String productTitle, int productPrice,
			String buyerId, String buyerNick, Date reviewDate, int reviewScore, String review) {
		this.productNo = productNo;
		this.productImagePath = productImagePath;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.buyerId = buyerId;
		this.buyerNick = buyerNick;
		this.reviewDate = reviewDate;
		this.reviewScore = reviewScore;
		this.review = review;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "SellerPageReceivedReviewDTO [productNo=" + productNo + ", productImagePath=" + productImagePath
				+ ", productTitle=" + productTitle + ", productPrice=" + productPrice + ", buyerId=" + buyerId
				+ ", buyerNick=" + buyerNick + ", reviewDate=" + reviewDate + ", reviewScore=" + reviewScore
				+ ", review=" + review + "]";
	}
}