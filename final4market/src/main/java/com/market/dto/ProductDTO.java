package com.market.dto;

public class ProductDTO {
	private int productNo;
	private String memberId;
	private int productPrice;
	private int productCount;
	private String productDate;
	private String productStatus;
	private String productContent;
	private String productSale;
	private String productTitle;
	private int productLike;
	private int categoryNo;
	private int deliveryNo;
	
	public ProductDTO() {
		
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

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
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

	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", memberId=" + memberId + ", productPrice=" + productPrice
				+ ", productCount=" + productCount + ", productDate=" + productDate + ", productStatus=" + productStatus
				+ ", productContent=" + productContent + ", productSale=" + productSale + ", productTitle="
				+ productTitle + ", productLike=" + productLike + ", categoryNo=" + categoryNo + ", deliveryNo="
				+ deliveryNo + "]";
	}
	
	
}
