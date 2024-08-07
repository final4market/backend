package com.market.dto;

public class StoreDTO {
	private String sellerId;
	private String buyerId;
	private int productNo;
	private int followerCount;
	private int saleCount;
	private int salePrice;
	private String review;
	private String saleStatus;
	private int reviewScore;

	public StoreDTO() {
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	@Override
	public String toString() {
		return "StoreDTO [sellerId=" + sellerId + ", buyerId=" + buyerId + ", productNo=" + productNo
				+ ", followerCount=" + followerCount + ", saleCount=" + saleCount + ", salePrice=" + salePrice
				+ ", review=" + review + ", saleStatus=" + saleStatus + ", reviewScore=" + reviewScore + "]";
	}

	
	
	
}
