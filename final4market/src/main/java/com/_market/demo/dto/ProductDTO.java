package com._market.demo.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("Product")
public class ProductDTO {

	private int ProductNo;
    private String memberId;
    private int productPrice;
    private int productCount;
    private Date productDate;
    private String productStatus;
    private String productContent;
    private String productSale;
    private String productTitle;
    private int categoryNo;
    private int deliveryNo;
    private String tradeArea;

    public ProductDTO() {
    }

    
    
	public int getProductNo() {
		return ProductNo;
	}

	public ProductDTO(int productNo, String memberId, int productPrice, String productStatus, String productContent,
			String productTitle, int categoryNo, int deliveryNo, String tradeArea) {
		
		ProductNo = productNo;
		this.memberId = memberId;
		this.productPrice = productPrice;
		this.productStatus = productStatus;
		this.productContent = productContent;
		this.productTitle = productTitle;
		this.categoryNo = categoryNo;
		this.deliveryNo = deliveryNo;
		this.tradeArea = tradeArea;
	}



	public void setProductNo(int productNo) {
		ProductNo = productNo;
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

	@Override
	public String toString() {
		return "ProductDTO [ProductNo=" + ProductNo + ", memberId=" + memberId + ", productPrice=" + productPrice
				+ ", productCount=" + productCount + ", productDate=" + productDate + ", productStatus=" + productStatus
				+ ", productContent=" + productContent + ", productSale=" + productSale + ", productTitle="
				+ productTitle + ", categoryNo=" + categoryNo + ", deliveryNo=" + deliveryNo + ", tradeArea="
				+ tradeArea + "]";
	}
    
	}
