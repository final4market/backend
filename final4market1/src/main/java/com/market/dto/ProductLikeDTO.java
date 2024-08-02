package com.market.dto;

public class ProductLikeDTO {
	private String buyerId;
	private int productNo;

	public ProductLikeDTO() {
	}

	public ProductLikeDTO(String buyerId, int productNo) {
		super();
		this.buyerId = buyerId;
		this.productNo = productNo;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "ProductLikeDTO [buyerId=" + buyerId + ", productNo=" + productNo + "]";
	}

}