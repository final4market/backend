package com.market.dto;

public class SellerPageFollowListDTO {
	private String sellerProfilePath;
	private String sellerId;
	private String sellerNick;
	private String sellerFollowCount;

	public SellerPageFollowListDTO() {
	}

	public SellerPageFollowListDTO(String sellerProfilePath, String sellerId, String sellerNick,
			String sellerFollowCount) {
		this.sellerProfilePath = sellerProfilePath;
		this.sellerId = sellerId;
		this.sellerNick = sellerNick;
		this.sellerFollowCount = sellerFollowCount;
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

	public String getSellerFollowCount() {
		return sellerFollowCount;
	}

	public void setSellerFollowCount(String sellerFollowCount) {
		this.sellerFollowCount = sellerFollowCount;
	}

	@Override
	public String toString() {
		return "SellerPageFollowListDTO [sellerProfilePath=" + sellerProfilePath + ", sellerId=" + sellerId
				+ ", sellerNick=" + sellerNick + ", sellerFollowCount=" + sellerFollowCount + "]";
	}
}