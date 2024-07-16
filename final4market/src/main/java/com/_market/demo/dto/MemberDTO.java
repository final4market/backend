package com._market.demo.dto;

import java.time.LocalDate;
import org.apache.ibatis.type.Alias;

@Alias("member")
public class MemberDTO {
	private String memberId;
	private String memberName;
	private String memberPwd;
	private String memberNick;
	private String memberEmail;
	private String memberAddr;	
	private int memberProfile;
	private int memberGrade;
	private String memberPhoneNo;
	private LocalDate memberRegDate;
	
	
	public MemberDTO() {

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


	public String getMemberPwd() {
		return memberPwd;
	}


	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
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


	public String getMemberAddr() {
		return memberAddr;
	}


	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
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


	public String getMemberPhoneNo() {
		return memberPhoneNo;
	}


	public void setMemberPhoneNo(String memberPhoneNo) {
		this.memberPhoneNo = memberPhoneNo;
	}


	public LocalDate getMemberRegDate() {
		return memberRegDate;
	}


	public void setMemberRegDate(LocalDate memberRegDate) {
		this.memberRegDate = memberRegDate;
	}


	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberName=" + memberName + ", memberPwd=" + memberPwd
				+ ", memberNick=" + memberNick + ", memberEmail=" + memberEmail + ", memberAddr=" + memberAddr
				+ ", memberProfile=" + memberProfile + ", memberGrade=" + memberGrade + ", memberPhoneNo="
				+ memberPhoneNo + ", memberRegDate=" + memberRegDate + "]";
	}		
	
}



