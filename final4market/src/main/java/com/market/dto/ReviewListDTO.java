package com.market.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

	@Alias("reviewList")
public class ReviewListDTO {
   private int productNo;
	private String memberId;
	private int productPrice;
	private int productCount;
	private Date productDate;
	private String productStatus;
	private String productContent;
	private String productSale;
	private String productTitle;
	private int productLike;
	private int categoryNo;
	private int deliveryNo;
	private String tradeArea;
	private int deliveryCharge;
   private String buyerId;
   private String review;
   private String sellerId;
   private Date reviewDate;
   private int reviewScore;
   private int productImageNo;
   private String productImagePath;

   public int getProductImageNo() {
	return productImageNo;
}

public void setProductImageNo(int productImageNo) {
	this.productImageNo = productImageNo;
}

public String getProductImagePath() {
	return productImagePath;
}

public void setProductImagePath(String productImagePath) {
	this.productImagePath = productImagePath;
}

public ReviewListDTO() {

	
}

public ReviewListDTO(int productNo, String memberId, int productPrice, int productCount, Date productDate,
		String productStatus, String productContent, String productSale, String productTitle, int productLike,
		int categoryNo, int deliveryNo, String tradeArea, int deliveryCharge, String buyerId, String review,
		String sellerId, Date reviewDate, int reviewScore) {
	super();
	this.productNo = productNo;
	this.memberId = memberId;
	this.productPrice = productPrice;
	this.productCount = productCount;
	this.productDate = productDate;
	this.productStatus = productStatus;
	this.productContent = productContent;
	this.productSale = productSale;
	this.productTitle = productTitle;
	this.productLike = productLike;
	this.categoryNo = categoryNo;
	this.deliveryNo = deliveryNo;
	this.tradeArea = tradeArea;
	this.deliveryCharge = deliveryCharge;
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

public String getMemberId() {
	return memberId;
}

public void setMemberId(String memberId) {
	this.memberId = memberId;
}

public int getProductPrice() {
	return productPrice;
}

public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}

public int getProductCount() {
	return productCount;
}

public void setProductCount(int productCount) {
	this.productCount = productCount;
}

public Date getProductDate() {
	return productDate;
}

public void setProductDate(Date productDate) {
	this.productDate = productDate;
}

public String getProductStatus() {
	return productStatus;
}

public void setProductStatus(String productStatus) {
	this.productStatus = productStatus;
}

public String getProductContent() {
	return productContent;
}

public void setProductContent(String productContent) {
	this.productContent = productContent;
}

public String getProductSale() {
	return productSale;
}

public void setProductSale(String productSale) {
	this.productSale = productSale;
}

public String getProductTitle() {
	return productTitle;
}

public void setProductTitle(String productTitle) {
	this.productTitle = productTitle;
}

public int getProductLike() {
	return productLike;
}

public void setProductLike(int productLike) {
	this.productLike = productLike;
}

public int getCategoryNo() {
	return categoryNo;
}

public void setCategoryNo(int categoryNo) {
	this.categoryNo = categoryNo;
}

public int getDeliveryNo() {
	return deliveryNo;
}

public void setDeliveryNo(int deliveryNo) {
	this.deliveryNo = deliveryNo;
}

public String getTradeArea() {
	return tradeArea;
}

public void setTradeArea(String tradeArea) {
	this.tradeArea = tradeArea;
}

public int getDeliveryCharge() {
	return deliveryCharge;
}

public void setDeliveryCharge(int deliveryCharge) {
	this.deliveryCharge = deliveryCharge;
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

	}


