package com.market.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("chat")
public class ChatDTO {
    private int chatNo;
    private int messageNo;
    private String receiverId;
    private String senderId;
    private int productNo;
    private String chatContent;
    private LocalDateTime chatDate;
    private String chatStatus;

    // 기본 생성자
    public ChatDTO() {
    }

	public ChatDTO(int chatNo, int messageNo, String receiverId, String senderId, int productNo, String chatContent,
			LocalDateTime chatDate, String chatStatus) {
		super();
		this.chatNo = chatNo;
		this.messageNo = messageNo;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.productNo = productNo;
		this.chatContent = chatContent;
		this.chatDate = chatDate;
		this.chatStatus = chatStatus;
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public int getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
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

	public LocalDateTime getChatDate() {
		return chatDate;
	}

	public void setChatDate(LocalDateTime chatDate) {
		this.chatDate = chatDate;
	}

	public String getChatStatus() {
		return chatStatus;
	}

	public void setChatStatus(String chatStatus) {
		this.chatStatus = chatStatus;
	}

	@Override
	public String toString() {
		return "ChatDTO [chatNo=" + chatNo + ", messageNo=" + messageNo + ", receiverId=" + receiverId + ", senderId="
				+ senderId + ", productNo=" + productNo + ", chatContent=" + chatContent + ", chatDate=" + chatDate
				+ ", chatStatus=" + chatStatus + "]";
	}

    
    
 
}
