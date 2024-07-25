package com.market.dto;

public class MyPageProductDTO {
	private String ProductImagePath;
	private String ProductTitle;
	private int ProductPrice;
	private int InterestCount;
	private int ChatCount;

	public MyPageProductDTO() {
	}

	public MyPageProductDTO(String productImagePath, String productTitle, int productPrice, int interestCount,
			int chatCount) {
		ProductImagePath = productImagePath;
		ProductTitle = productTitle;
		ProductPrice = productPrice;
		InterestCount = interestCount;
		ChatCount = chatCount;
	}

	public String getProductImagePath() {
		return ProductImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		ProductImagePath = productImagePath;
	}

	public String getProductTitle() {
		return ProductTitle;
	}

	public void setProductTitle(String productTitle) {
		ProductTitle = productTitle;
	}

	public int getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}

	public int getInterestCount() {
		return InterestCount;
	}

	public void setInterestCount(int interestCount) {
		InterestCount = interestCount;
	}

	public int getChatCount() {
		return ChatCount;
	}

	public void setChatCount(int chatCount) {
		ChatCount = chatCount;
	}

	@Override
	public String toString() {
		return "MyPageProductDTO [ProductImagePath=" + ProductImagePath + ", ProductTitle=" + ProductTitle
				+ ", ProductPrice=" + ProductPrice + ", InterestCount=" + InterestCount + ", ChatCount=" + ChatCount
				+ "]";
	}
}