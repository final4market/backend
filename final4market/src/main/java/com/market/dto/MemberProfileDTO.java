package com.market.dto;

import org.apache.ibatis.type.Alias;

@Alias("profile")
public class MemberProfileDTO {
	private int memberProfileNo;
	private String profilePath;

	public MemberProfileDTO() {
	}

	public MemberProfileDTO(int memberProfileNo, String profilePath) {
		this.memberProfileNo = memberProfileNo;
		this.profilePath = profilePath;
	}

	public int getMemberProfileNo() {
		return memberProfileNo;
	}

	public void setMemberProfileNo(int memberProfileNo) {
		this.memberProfileNo = memberProfileNo;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	@Override
	public String toString() {
		return "MemberProfileDTO [memberProfileNo=" + memberProfileNo + ", profilePath=" + profilePath + "]";
	}
}