package com._market.demo.dto;

import org.apache.ibatis.type.Alias;

@Alias("grade")
public class MemberGradeDTO {
	private int memberGrade;
	private String gradeName;

	public MemberGradeDTO() {
	}

	public MemberGradeDTO(int memberGrade, String gradeName) {
		super();
		this.memberGrade = memberGrade;
		this.gradeName = gradeName;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@Override
	public String toString() {
		return "MemberGradeDTO [memberGrade=" + memberGrade + ", gradeName=" + gradeName + "]";
	}
}