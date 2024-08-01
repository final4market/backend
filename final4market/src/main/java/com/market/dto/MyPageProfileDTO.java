package com.market.dto;

public class MyPageProfileDTO {
	private String memberId;
	private String memberNick;
	private String memberProfilePath;
	private double memberScore;

	public MyPageProfileDTO() {
	}

	public MyPageProfileDTO(String memberId, String memberNick, String memberProfilePath, double memberScore) {
		this.memberId = memberId;
		this.memberNick = memberNick;
		this.memberProfilePath = memberProfilePath;
		this.memberScore = memberScore;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getMemberProfilePath() {
		return memberProfilePath;
	}

	public void setMemberProfilePath(String memberProfilePath) {
		this.memberProfilePath = memberProfilePath;
	}

	public double getMemberScore() {
		return memberScore;
	}

	public void setMemberScore(double memberScore) {
		this.memberScore = memberScore;
	}

	@Override
	public String toString() {
		return "MyPageProfileDTO [memberId=" + memberId + ", memberNick=" + memberNick + ", memberProfilePath="
				+ memberProfilePath + ", memberScore=" + memberScore + "]";
	}
}