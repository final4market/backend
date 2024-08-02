package com.market.models;


public class ProductImage {
    private int productImageNo;
    private int productNo;
    private String productImagePath;

    public ProductImage() {
    }

    public ProductImage(String productImagePath, int productNo) {
        this.productImagePath = productImagePath;
        this.productNo = productNo;
    }

    public int getProductImageNo() {
        return productImageNo;
    }

    public void setProductImageNo(int productImageNo) {
        this.productImageNo = productImageNo;
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
        return "ProductImage{" +
                "productImageNo=" + productImageNo +
                ", productNo=" + productNo +
                ", productImagePath='" + productImagePath + '\'' +
                '}';
    }
}