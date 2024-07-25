package com.market.dto;

public class MyPageProfileDTO {
	private String memberProfilePath;
	private String memberNick;
	private double memberScore;

	public MyPageProfileDTO() {
	}

	public MyPageProfileDTO(String memberProfilePath, String memberNick, double memberScore) {
		this.memberProfilePath = memberProfilePath;
		this.memberNick = memberNick;
		this.memberScore = memberScore;
	}

	public String getMemberProfilePath() {
		return memberProfilePath;
	}

	public void setMemberProfilePath(String memberProfilePath) {
		this.memberProfilePath = memberProfilePath;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public double getMemberScore() {
		return memberScore;
	}

	public void setMemberScore(double memberScore) {
		this.memberScore = memberScore;
	}

	@Override
	public String toString() {
		return "MyPageProfileDTO [memberProfilePath=" + memberProfilePath + ", memberNick=" + memberNick
				+ ", memberScore=" + memberScore + "]";
	}
}