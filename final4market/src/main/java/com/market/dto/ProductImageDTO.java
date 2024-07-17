package com.market.dto;

import org.apache.ibatis.type.Alias;

@Alias("productImage")
public class ProductImageDTO {
	private int productNo;
	private String productImagePath;

	public ProductImageDTO() {
	}

	public ProductImageDTO(String productImagePath, int productNo) {
		this.productImagePath = productImagePath;
		this.productNo = productNo;
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
