package com.market.dto;

import org.apache.ibatis.type.Alias;

@Alias("profile")
public class ProfileImageDTO {
	private int memberProfileNo;
	private String memberProfilePath;

	public ProfileImageDTO() {
	}

	public ProfileImageDTO(int memberProfileNo, String memberProfilePath) {
		this.memberProfileNo = memberProfileNo;
		this.memberProfilePath = memberProfilePath;
	}

	public int getMemberProfile() {
		return memberProfileNo;
	}

	public void setMemberProfile(int memberProfileNo) {
		this.memberProfileNo = memberProfileNo;
	}

	public String getProfilePath() {
		return memberProfilePath;
	}

	public void setMemberProfilePath(String memberProfilePath) {
		this.memberProfilePath = memberProfilePath;
	}

	@Override
	public String toString() {
		return "ProfileDTO [memberProfileNo=" + memberProfileNo + ", memberProfilePath=" + memberProfilePath + "]";
	}

}