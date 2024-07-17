package com.market.dto;

import org.apache.ibatis.type.Alias;

public class ProductImageDTO {
	private int productNo;
	private String productImagePath;
		
	public ProductImageDTO() {
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

	@Override
	public String toString() {
		return "ProductImageDTO [productNo=" + productNo + ", productImagePath=" + productImagePath + "]";
	}
	
	
}
