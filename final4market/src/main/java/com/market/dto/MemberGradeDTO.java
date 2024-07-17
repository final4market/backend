package com.market.dto;

import org.apache.ibatis.type.Alias;

@Alias("grade")
public class MemberGradeDTO {
	private int memberGrade;
	private String gradeName;

	public MemberGradeDTO() {
	}

	public int getmemberGrade() {
		return memberGrade;
	}

	public void setmemberGrade(int memberGrade) {
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
		return "GradeDTO [memberGrade=" + memberGrade + ", gradeName=" + gradeName + "]";
	}

}
