package com._market.demo.dto;

import org.apache.ibatis.type.Alias;

@Alias("profile")
public class ProfileDTO {
	private int memberProfile;
	private String profilePath;

	public ProfileDTO() {
	}

	public ProfileDTO(int memberProfile, String profilePath) {
		this.memberProfile = memberProfile;
		this.profilePath = profilePath;
	}

	public int getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(int memberProfile) {
		this.memberProfile = memberProfile;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	@Override
	public String toString() {
		return "ProfileDTO [memberProfile=" + memberProfile + ", profilePath=" + profilePath + "]";
	}

}