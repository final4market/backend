package com.market.dto;


import java.io.File;

import org.apache.ibatis.type.Alias;

@Alias("productImage")
public class ProductImageDTO {
	private int productNo;
	private int productImageNo;
	private String productImagePath;
	private String fileName;
	private String type;

	public ProductImageDTO() {
	}

	public ProductImageDTO(String productImagePath, int productNo) {
		this.productImagePath = productImagePath;
		this.productNo = productNo;
	}
	
	public ProductImageDTO(File file, int productNo, int productImageNo) {
		this.productNo = productNo;
		this.productImageNo = productImageNo;
		this.productImagePath = file.getAbsolutePath();
		this.fileName = file.getName();
		String postfix = file.getName().substring(fileName.lastIndexOf(".")+1).toLowerCase();
		switch(postfix) {
		case "png":
		case "jpg":
		case "gif":
		case "bmp":
		case "jfif":
			this.type = "image";
			break;
		case "mp4":
			this.type = "video";
			break;
		}}
	
	public ProductImageDTO(File file, int productNo) {
		this.productNo = productNo;
		this.productImagePath = file.getAbsolutePath();
	}

	public int getProductNo() {
		return productNo;
	}

	public int getProductImageNo() {
		return productImageNo;
	}

	public void setProductImageNo(int productImageNo) {
		this.productImageNo = productImageNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String path) {
		this.productImagePath = path;
		File file = new File(path);
		this.fileName = file.getName();
		String postfix = file.getName().substring(fileName.lastIndexOf(".")+1).toLowerCase();
		switch(postfix) {
		case "png":
		case "jpg":
		case "gif":
		case "bmp":
			this.type = "image";
			break;
		case "mp4":
			this.type = "video";
			break;
		default:
			this.type = "normal";
		}
	}
	

	@Override
	public String toString() {
		return "ProductImageDTO [productNo=" + productNo + ", productImagePath=" + productImagePath + "]";
	}

}
