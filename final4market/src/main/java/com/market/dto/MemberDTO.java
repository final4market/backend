package com.market.dto;

import java.time.LocalDateTime;
import com.market.models.Member;

public class MemberDTO {
    private String memberId;
    private String memberName;
    private String memberPasswd;
    private String memberNick;
    private String memberEmail;
    private String memberAddr;
    private int memberProfileNo;
    private int memberGrade;
    private String memberPhoneNo;
    private LocalDateTime memberRegDate;
    private String memberGradeName;
    private String token;

    public MemberDTO() {
    }

    // 모든 필드 포함 생성자
    public MemberDTO(String memberId, String memberName, String memberPasswd, String memberNick, String memberEmail,
                     String memberAddr, int memberProfileNo, int memberGrade, String memberPhoneNo, LocalDateTime memberRegDate, String memberGradeName,
                     String token) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPasswd = memberPasswd;
        this.memberNick = memberNick;
        this.memberEmail = memberEmail;
        this.memberAddr = memberAddr;
        this.memberProfileNo = memberProfileNo;
        this.memberGrade = memberGrade;
        this.memberPhoneNo = memberPhoneNo;
        this.memberRegDate = memberRegDate;
        this.memberGradeName = memberGradeName;
        this.token = token;
    }
    
    public MemberDTO(String memberId, String memberName, String memberPasswd, String memberEmail, String memberPhoneNo) {
    	this.memberId = memberId;
    	this.memberName = memberName;
    	this.memberPasswd = memberPasswd;
    	this.memberEmail = memberEmail;
    	this.memberPhoneNo = memberPhoneNo;
    }

    // member 클래스로부터 memberDTO를 만드는 생성자
    public MemberDTO(Member member) {
        this.memberId = member.getMemberId();
        this.memberName = member.getMemberName();
        this.memberPasswd = member.getMemberPasswd();
        this.memberNick = member.getMemberNick();
        this.memberEmail = member.getMemberEmail();
        this.memberAddr = member.getMemberAddr();
        this.memberProfileNo = member.getMemberProfileNo();
        this.memberGrade = member.getMemberGrade();
        this.memberPhoneNo = member.getMemberPhoneNo();
        this.memberRegDate = member.getMemberRegDate();
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getMemberPasswd() {
        return memberPasswd;
    }

    public void setMemberPasswd(String memberPasswd) {
        this.memberPasswd = memberPasswd;
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

    public int getMemberProfileNo() {
        return memberProfileNo;
    }

    public void setMemberProfileNo(int memberProfileNo) {
        this.memberProfileNo = memberProfileNo;
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

    public LocalDateTime getMemberRegDate() {
        return memberRegDate;
    }

    public void setMemberRegDate(LocalDateTime memberRegDate) {
        this.memberRegDate = memberRegDate;
    }
    
    public String getMemberGradeName() {
        return memberGradeName;
    }

    public void setMemberGradeName(String memberGradeName) {
        this.memberGradeName = memberGradeName;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPasswd='" + memberPasswd + '\'' +
                ", memberNick='" + memberNick + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberAddr='" + memberAddr + '\'' +
                ", memberProfileNo=" + memberProfileNo +
                ", memberGrade=" + memberGrade +
                ", memberPhoneNo='" + memberPhoneNo + '\'' +
                ", memberRegDate=" + memberRegDate +
                ", memberGradeName='" + memberGradeName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
