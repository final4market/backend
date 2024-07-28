package com.market.dto;

public class MyPageInfoDTO {
	private String memberProfilePath;
	private String memberId;
	private String memberPasswd;
	private String memberName;
	private String memberNick;
	private String memberPhoneNumber;
	private String memberEmail;
	private String memberAddress;

	public MyPageInfoDTO() {
	}

	public MyPageInfoDTO(String memberProfilePath, String memberId, String memberPasswd, String memberName,
			String memberNick, String memberPhoneNumber, String memberEmail, String memberAddress) {
		this.memberProfilePath = memberProfilePath;
		this.memberId = memberId;
		this.memberPasswd = memberPasswd;
		this.memberName = memberName;
		this.memberNick = memberNick;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
	}

	public String getMemberProfilePath() {
		return memberProfilePath;
	}

	public void setMemberProfilePath(String memberProfilePath) {
		this.memberProfilePath = memberProfilePath;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPasswd() {
		return memberPasswd;
	}

	public void setMemberPasswd(String memberPasswd) {
		this.memberPasswd = memberPasswd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	@Override
	public String toString() {
		return "MyPageInfoDTO [memberProfilePath=" + memberProfilePath + ", memberId=" + memberId + ", memberPasswd="
				+ memberPasswd + ", memberName=" + memberName + ", memberNick=" + memberNick + ", memberPhoneNumber="
				+ memberPhoneNumber + ", memberEmail=" + memberEmail + ", memberAddress=" + memberAddress + "]";
	}
}