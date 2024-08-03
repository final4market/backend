package com.market.models;

import java.time.LocalDateTime;

public class Member {
    private String memberId;
    private String memberName;
    private String memberPasswd;
    private String memberNick;
    private String memberEmail;
    private String memberAddr;
    private String memberPhoneNo;
    private int memberProfileNo = -1; // 프로필 사진 없을 때 기본값
    private int memberGrade = 1; // 기본값
    private LocalDateTime memberRegDate = LocalDateTime.now(); // 기본값


    public Member() {
    }

    // 가입 시 필요한 부분에 대한 생성자
    public Member(String memberId, String memberName, String memberPasswd, String memberEmail, String memberPhoneNo) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPasswd = memberPasswd;
        this.memberEmail = memberEmail;
        this.memberPhoneNo = memberPhoneNo;
    }

    // 회원 정보 전체에 대한 생성자
    public Member(String memberId, String memberName, String memberPasswd, String memberEmail, String memberPhoneNo,
                  String memberNick, String memberAddr, int memberProfileNo, int memberGrade, LocalDateTime memberRegDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPasswd = memberPasswd;
        this.memberEmail = memberEmail;
        this.memberPhoneNo = memberPhoneNo;
        this.memberNick = memberNick;
        this.memberAddr = memberAddr;
        this.memberProfileNo = memberProfileNo;
        this.memberGrade = memberGrade;
        this.memberRegDate = memberRegDate;
    }


    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getMemberPasswd() { return memberPasswd; }
    public void setMemberPasswd(String memberPasswd) { this.memberPasswd = memberPasswd; }
    public String getMemberNick() { return memberNick; }
    public void setMemberNick(String memberNick) { this.memberNick = memberNick; }
    public String getMemberEmail() { return memberEmail; }
    public void setMemberEmail(String memberEmail) { this.memberEmail = memberEmail; }
    public String getMemberAddr() { return memberAddr; }
    public void setMemberAddr(String memberAddr) { this.memberAddr = memberAddr; }
    public String getMemberPhoneNo() { return memberPhoneNo; }
    public void setMemberPhoneNo(String memberPhoneNo) { this.memberPhoneNo = memberPhoneNo; }
    public int getMemberProfileNo() { return memberProfileNo; }
    public void setMemberProfileNo(int memberProfileNo) { this.memberProfileNo = memberProfileNo; }
    public int getMemberGrade() { return memberGrade; }
    public void setMemberGrade(int memberGrade) { this.memberGrade = memberGrade; }
    public LocalDateTime getMemberRegDate() { return memberRegDate; }
    public void setMemberRegDate(LocalDateTime memberRegDate) { this.memberRegDate = memberRegDate; }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPasswd='[PROTECTED]'" +
                ", memberNick='" + memberNick + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberAddr='" + memberAddr + '\'' +
                ", memberProfileNo=" + memberProfileNo +
                ", memberGrade=" + memberGrade +
                ", memberRegDate=" + memberRegDate +
                '}';
    }
}
