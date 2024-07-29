package com.market.models;

public class MemberProfile {
    private int memberProfileNo;
    private String profilePath;
    private String memberId;

    public MemberProfile() {
    }

    public MemberProfile(String profilePath, String memberId) {
        this.profilePath = profilePath;
        this.memberId = memberId;
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "ProfileImage{" +
                "memberProfileNo=" + memberProfileNo +
                ", profilePath='" + profilePath + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
