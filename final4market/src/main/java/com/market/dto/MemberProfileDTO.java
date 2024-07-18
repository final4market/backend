package com.market.dto;

import org.apache.ibatis.type.Alias;

@Alias("profile")
public class MemberProfileDTO {
	private int memberProfileNo;
	private String memberProfilePath;
	
	public MemberProfileDTO() {
	}
	
	public MemberProfileDTO(int memberProfileNo, String memberProfilePath) {
		this.memberProfileNo = memberProfileNo;
		this.memberProfilePath = memberProfilePath;
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

	@Override
	public String toString() {
		return "MemberProfileDTO [MemberProfileNo=" + memberProfileNo + ", MemberProfilePath=" + memberProfilePath
				+ "]";
	}
	
	
	
	
	
}
