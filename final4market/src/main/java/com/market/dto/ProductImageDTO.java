package com.market.dto;

import java.io.File;

import org.apache.ibatis.type.Alias;

@Alias("productImage")
public class ProductImageDTO {       
    private int productNo;
    private int productImageNo;
    private String productImagePath;

    public ProductImageDTO(int productNo, String productImagePath) {
		this.productNo = productNo;
		this.productImagePath = productImagePath;
	}

	public ProductImageDTO() {
    }


    public ProductImageDTO(int productNo, int productImageNo, String productImagePath) {
    	this.productNo = productNo;
        this.productImageNo = productImageNo;
        this.productImagePath = productImagePath;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

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

    @Override
    public String toString() {
        return "ProductImageDTO [productNo=" + productNo + ", productImageNo=" + productImageNo + ", productImagePath=" + productImagePath + "]";
    }
}
