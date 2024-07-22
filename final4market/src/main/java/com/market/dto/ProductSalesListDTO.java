package com.market.dto;

import java.sql.Date;

public class ProductSalesListDTO {
 
	private String memberId;
	private int productPrice;
	private String productStatus;
	private String productTitle;
	private String productImagePath;
	private Date thDate;
	


	public ProductSalesListDTO() {

	}
	

	public ProductSalesListDTO(String memberId, int productPrice, String productStatus, String productTitle,
			String productImagePath, Date thDate) {
		super();
		this.memberId = memberId;
		this.productPrice = productPrice;
		this.productStatus = productStatus;
		this.productTitle = productTitle;
		this.productImagePath = productImagePath;
		this.thDate = thDate;
	}


	public Date getThDate() {
		return thDate;
	}

	public void setThDate(Date thDate) {
		this.thDate = thDate;
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

	
	
}
