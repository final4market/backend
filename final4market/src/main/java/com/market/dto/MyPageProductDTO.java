package com.market.dto;

public class MyPageProductDTO {
	private int productNo;
	private String memberId;
	private String productImagePath;
	private String productTitle;
	private int productPrice;
	private int interestCount;
	private int chatCount;

	public MyPageProductDTO() {
	}

	public MyPageProductDTO(int productNo, String memberId, String productImagePath, String productTitle,
			int productPrice, int interestCount, int chatCount) {
		this.productNo = productNo;
		this.memberId = memberId;
		this.productImagePath = productImagePath;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.interestCount = interestCount;
		this.chatCount = chatCount;
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

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getInterestCount() {
		return interestCount;
	}

	public void setInterestCount(int interestCount) {
		this.interestCount = interestCount;
	}

	public int getChatCount() {
		return chatCount;
	}

	public void setChatCount(int chatCount) {
		this.chatCount = chatCount;
	}

	@Override
	public String toString() {
		return "MyPageProductDTO [productNo=" + productNo + ", memberId=" + memberId + ", productImagePath="
				+ productImagePath + ", productTitle=" + productTitle + ", productPrice=" + productPrice
				+ ", interestCount=" + interestCount + ", chatCount=" + chatCount + "]";
	}
}