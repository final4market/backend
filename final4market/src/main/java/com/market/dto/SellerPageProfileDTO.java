package com.market.dto;

public class SellerPageProfileDTO {
	private String sellerProfilePath;
	private String sellerId;
	private String sellerNick;
	private double sellerScore;

	public SellerPageProfileDTO() {
	}

	public SellerPageProfileDTO(String sellerProfilePath, String sellerId, String sellerNick, double sellerScore) {
		this.sellerProfilePath = sellerProfilePath;
		this.sellerId = sellerId;
		this.sellerNick = sellerNick;
		this.sellerScore = sellerScore;
	}

	public String getSellerProfilePath() {
		return sellerProfilePath;
	}

	public void setSellerProfilePath(String sellerProfilePath) {
		this.sellerProfilePath = sellerProfilePath;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerNick() {
		return sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public double getSellerScore() {
		return sellerScore;
	}

	public void setSellerScore(double sellerScore) {
		this.sellerScore = sellerScore;
	}

	@Override
	public String toString() {
		return "SellerPageProfileDTO [sellerProfilePath=" + sellerProfilePath + ", sellerId=" + sellerId
				+ ", sellerNick=" + sellerNick + ", sellerScore=" + sellerScore + "]";
	}
}