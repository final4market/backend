package com.market.dto;

public class MemberProfileDTO {
	private int MemberProfileNo;
	private String MemberProfilePath;
	
	public MemberProfileDTO() {
	}

	public int getMemberProfileNo() {
		return MemberProfileNo;
	}

	public void setMemberProfileNo(int memberProfileNo) {
		MemberProfileNo = memberProfileNo;
	}

	public String getMemberProfilePath() {
		return MemberProfilePath;
	}

	public void setMemberProfilePath(String memberProfilePath) {
		MemberProfilePath = memberProfilePath;
	}

	@Override
	public String toString() {
		return "MemberProfileDTO [MemberProfileNo=" + MemberProfileNo + ", MemberProfilePath=" + MemberProfilePath
				+ "]";
	}
	
	
	
	
	
}
