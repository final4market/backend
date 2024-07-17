package com._market.demo.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("member")
public class MemberDTO {
	private String memberId;
	private String memberName;
	private String memberPasswd;
	private String memberNick;
	private String memberEmail;
	private String memberAddress;
	private int memberProfile;
	private int memberGrade;
	private String memberPhoneNumber;
	private Date registerDate;

	public MemberDTO() {
	}

	public MemberDTO(String memberId, String memberName, String memberPasswd, String memberNick, String memberEmail,
			String memberAddress, int memberProfile, int memberGrade, String memberPhoneNumber, Date registerDate) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPasswd = memberPasswd;
		this.memberNick = memberNick;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberProfile = memberProfile;
		this.memberGrade = memberGrade;
		this.memberPhoneNumber = memberPhoneNumber;
		this.registerDate = registerDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPasswd() {
		return memberPasswd;
	}

	public void setMemberPasswd(String memberPasswd) {
		this.memberPasswd = memberPasswd;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
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

	public int getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(int memberProfile) {
		this.memberProfile = memberProfile;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberName=" + memberName + ", memberPasswd=" + memberPasswd
				+ ", memberNick=" + memberNick + ", memberEmail=" + memberEmail + ", memberAddress=" + memberAddress
				+ ", memberProfile=" + memberProfile + ", memberGrade=" + memberGrade + ", memberPhoneNumber="
				+ memberPhoneNumber + ", registerDate=" + registerDate + "]";
	}

}