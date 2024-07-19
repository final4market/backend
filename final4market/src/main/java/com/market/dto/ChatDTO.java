package com.market.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("chat")
public class ChatDTO {
	private int chatNo;
	private String sellerId;
	private String buyerId;
	private int productNo;
	private String chatContent;
	private Date chatDate;

	public ChatDTO() {
	}

	public ChatDTO(int chatNo, String sellerId, String buyerId, int productNo, String chatContent, Date chatDate) {
		this.chatNo = chatNo;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.productNo = productNo;
		this.chatContent = chatContent;
		this.chatDate = chatDate;
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public Date getChatDate() {
		return chatDate;
	}

	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
	}

	@Override
	public String toString() {
		return "ChatDTO [chatNo=" + chatNo + ", sellerId=" + sellerId + ", buyerId=" + buyerId + ", productNo="
				+ productNo + ", chatContent=" + chatContent + ", chatDate=" + chatDate + "]";
	}
}