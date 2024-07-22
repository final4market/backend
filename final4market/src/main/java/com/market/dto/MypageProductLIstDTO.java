package com.market.dto;

import java.sql.Date;

public class MypageProductLIstDTO {
  
	private String memberId;
    private int productNo;
	private int productPrice;
	private String productStatus;
	private String productTitle;
	private String productImagePath;
	private Date thDate;
	private String buyerId;


	public MypageProductLIstDTO() {

	}


	public MypageProductLIstDTO(String memberId, int productNo, int productPrice, String productStatus,
			String productTitle, String productImagePath, Date thDate, String buyerId) {
		super();
		this.memberId = memberId;
		this.productNo = productNo;
		this.productPrice = productPrice;
		this.productStatus = productStatus;
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


	public String getProductStatus() {
		return productStatus;
	}


	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
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
