package com.market.dto;

import java.sql.Date;

public class MypageProductLIstDTO {
  
	private int productNo;
	private String memberId;
	private int productPrice;
	private int productCount;
	private Date productDate;
	private String productStatus;
	private String productContent;
	private String productSale;
	private String productTitle;
	private int categoryNo;
	private int deliveryNo;
	private String tradeArea;
	private int deliveryCharge;
	private String productImagePath;
	private String review;
	private String sellerId;
	private Date reviewDate;
	private int reviewScore;
	private Date thDate;
	private String buyerId;
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

	public void setProductCount(int productCount) {
		this.productCount = productCount;
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
	
	
	public Date getProductDate() {
		return productDate;
	}


	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}


	public MypageProductLIstDTO() {

	}

	

	public MypageProductLIstDTO(String memberId, int productNo, int productPrice, String productSale,
			String productTitle, String productImagePath, Date productDate, Date thDate, String buyerId) {
		super();
		this.memberId = memberId;
		this.productNo = productNo;
		this.productPrice = productPrice;
		this.productSale = productSale;
		this.productTitle = productTitle;
		this.productImagePath = productImagePath;
		this.productDate = productDate;
		this.thDate = thDate;
		this.buyerId = buyerId;
	}


	public MypageProductLIstDTO(String memberId, int productNo, int productPrice, String productSale,
			String productTitle, String productImagePath, Date thDate, String buyerId) {
		super();
		this.memberId = memberId;
		this.productNo = productNo;
		this.productPrice = productPrice;
		this.productSale = productSale;
		this.productTitle = productTitle;
		this.productImagePath = productImagePath;
		this.thDate = thDate;
		this.buyerId = buyerId;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
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


	public String getProductImagePath() {
		return productImagePath;
	}


	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}


	public Date getThDate() {
		return thDate;
	}


	public void setThDate(Date thDate) {
		this.thDate = thDate;
	}


	public String getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	
}