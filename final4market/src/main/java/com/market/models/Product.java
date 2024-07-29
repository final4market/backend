package com.market.models;

import java.sql.Date;

public class Product {
    private int productNo;
    private String memberId;
    private int productPrice;
    private int productCount;
    private Date productDate;
    private String productStatus;
    private String productContent;
    private String productSale;
    private String productTitle;
    private int productLike;
    private int categoryNo;
    private int deliveryNo;
    private String tradeArea;
    private int deliveryCharge;


    public Product() {
    }

    public Product(int productNo, String memberId, int productPrice, int productCount, Date productDate,
                   String productStatus, String productContent, String productSale, String productTitle, int productLike,
                   int categoryNo, int deliveryNo, String tradeArea, int deliveryCharge) {
        this.productNo = productNo;
        this.memberId = memberId;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.productDate = productDate;
        this.productStatus = productStatus;
        this.productContent = productContent;
        this.productSale = productSale;
        this.productTitle = productTitle;
        this.productLike = productLike;
        this.categoryNo = categoryNo;
        this.deliveryNo = deliveryNo;
        this.tradeArea = tradeArea;
        this.deliveryCharge = deliveryCharge;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
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

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
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

    public int getProductLike() {
        return productLike;
    }

    public void setProductLike(int productLike) {
        this.productLike = productLike;
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

    @Override
    public String toString() {
        return "Product [productNo=" + productNo + ", memberId=" + memberId + ", productPrice=" + productPrice
                + ", productCount=" + productCount + ", productDate=" + productDate + ", productStatus=" + productStatus
                + ", productContent=" + productContent + ", productSale=" + productSale + ", productTitle=" + productTitle
                + ", productLike=" + productLike + ", categoryNo=" + categoryNo + ", deliveryNo=" + deliveryNo
                + ", tradeArea=" + tradeArea + ", deliveryCharge=" + deliveryCharge + "]";
    }
}
