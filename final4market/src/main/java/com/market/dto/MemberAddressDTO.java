package com.market.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.bind.annotation.RestController;

@Alias("address")
public class MemberAddressDTO {
	private int memberAddressNo;
	private String memberId;
	private String address;
	private String postalCode;
	private int mainAddress;
	private String memberName;
	private String memberPhoneNumber;

	public MemberAddressDTO(int memberAddressNo, String memberId, String address, String postalCode, int mainAddress,
			String memberName, String memberPhoneNumber) {
		super();
		this.memberAddressNo = memberAddressNo;
		this.memberId = memberId;
		this.address = address;
		this.postalCode = postalCode;
		this.mainAddress = mainAddress;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public MemberAddressDTO() {
	}

	public int getMemberAddressNo() {
		return memberAddressNo;
	}

	public void setMemberAddressNo(int memberAddressNo) {
		this.memberAddressNo = memberAddressNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(int mainAddress) {
		this.mainAddress = mainAddress;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	@Override
	public String toString() {
		return "MemberAddressDTO [memberAddressNo=" + memberAddressNo + ", memberId=" + memberId + ", address="
				+ address + ", postalCode=" + postalCode + ", mainAddress=" + mainAddress + ", memberName=" + memberName
				+ ", memberPhoneNumber=" + memberPhoneNumber + "]";
	}
	
	
	
}
