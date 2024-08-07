package com.market.dto;

public class MyPageMyInfoDTO {
	private int memberProfileNo;
	private String memberProfilePath;
	private String memberId;
	private String memberPasswd;
	private String memberName;
	private String memberNick;
	private String memberPhoneNumber1;
	private String memberPhoneNumber2;
	private String memberPhoneNumber3;
	private String memberEmailId;
	private String memberEmailDomain;
	private String memberPostalCode;
	private String memberAddress;
	private String memberDetailAddress;

	public MyPageMyInfoDTO() {
	}

	public MyPageMyInfoDTO(int memberProfileNo, String memberProfilePath, String memberId, String memberPasswd,
			String memberName, String memberNick, String memberPhoneNumber1, String memberPhoneNumber2,
			String memberPhoneNumber3, String memberEmailId, String memberEmailDomain, String memberPostalCode,
			String memberAddress, String memberDetailAddress) {
		this.memberProfileNo = memberProfileNo;
		this.memberProfilePath = memberProfilePath;
		this.memberId = memberId;
		this.memberPasswd = memberPasswd;
		this.memberName = memberName;
		this.memberNick = memberNick;
		this.memberPhoneNumber1 = memberPhoneNumber1;
		this.memberPhoneNumber2 = memberPhoneNumber2;
		this.memberPhoneNumber3 = memberPhoneNumber3;
		this.memberEmailId = memberEmailId;
		this.memberEmailDomain = memberEmailDomain;
		this.memberPostalCode = memberPostalCode;
		this.memberAddress = memberAddress;
		this.memberDetailAddress = memberDetailAddress;
	}

	public int getMemberProfileNo() {
		return memberProfileNo;
	}

	public void setMemberProfileNo(int memberProfileNo) {
		this.memberProfileNo = memberProfileNo;
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

	public String getMemberPhoneNumber1() {
		return memberPhoneNumber1;
	}

	public void setMemberPhoneNumber1(String memberPhoneNumber1) {
		this.memberPhoneNumber1 = memberPhoneNumber1;
	}

	public String getMemberPhoneNumber2() {
		return memberPhoneNumber2;
	}

	public void setMemberPhoneNumber2(String memberPhoneNumber2) {
		this.memberPhoneNumber2 = memberPhoneNumber2;
	}

	public String getMemberPhoneNumber3() {
		return memberPhoneNumber3;
	}

	public void setMemberPhoneNumber3(String memberPhoneNumber3) {
		this.memberPhoneNumber3 = memberPhoneNumber3;
	}

	public String getMemberEmailId() {
		return memberEmailId;
	}

	public void setMemberEmailId(String memberEmailId) {
		this.memberEmailId = memberEmailId;
	}

	public String getMemberEmailDomain() {
		return memberEmailDomain;
	}

	public void setMemberEmailDomain(String memberEmailDomain) {
		this.memberEmailDomain = memberEmailDomain;
	}

	public String getMemberPostalCode() {
		return memberPostalCode;
	}

	public void setMemberPostalCode(String memberPostalCode) {
		this.memberPostalCode = memberPostalCode;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberDetailAddress() {
		return memberDetailAddress;
	}

	public void setMemberDetailAddress(String memberDetailAddress) {
		this.memberDetailAddress = memberDetailAddress;
	}

	@Override
	public String toString() {
		return "MyPageMyInfoDTO [memberProfileNo=" + memberProfileNo + ", memberProfilePath=" + memberProfilePath
				+ ", memberId=" + memberId + ", memberPasswd=" + memberPasswd + ", memberName=" + memberName
				+ ", memberNick=" + memberNick + ", memberPhoneNumber1=" + memberPhoneNumber1 + ", memberPhoneNumber2="
				+ memberPhoneNumber2 + ", memberPhoneNumber3=" + memberPhoneNumber3 + ", memberEmailId=" + memberEmailId
				+ ", memberEmailDomain=" + memberEmailDomain + ", memberPostalCode=" + memberPostalCode
				+ ", memberAddress=" + memberAddress + ", memberDetailAddress=" + memberDetailAddress + "]";
	}
}