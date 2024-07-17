package com._market.demo.dto;

import org.apache.ibatis.type.Alias;

@Alias("image")
public class ImageDTO {
	private String productImagePath;
	private int productNo;

	public ImageDTO() {
	}

	public ImageDTO(String productImagePath, int productNo) {
		this.productImagePath = productImagePath;
		this.productNo = productNo;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "ProductImageDTO [productImagePath=" + productImagePath + ", productNo=" + productNo + "]";
	}
}