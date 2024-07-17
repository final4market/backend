package com.market.dto;

import java.io.File;

import org.apache.ibatis.type.Alias;

@Alias("ProductImage")
public class ProductImageDTO {
	private int productNo;
	private String path;
	
	public ProductImageDTO() {
	}

	public ProductImageDTO(File file, int productNo) {
		super();
		this.productNo = productNo;
		this.path = file.getAbsolutePath();
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ProductImageDTO [productNo=" + productNo + ", path=" + path + "]";
	}
	
}
