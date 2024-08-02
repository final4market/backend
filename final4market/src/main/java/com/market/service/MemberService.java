package com.market.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.market.dto.MemberAddressDTO;
import com.market.dto.MemberDTO;
import com.market.dto.MyPageMyInfoDTO;
import com.market.dto.MyPageProfileDTO;
import com.market.dto.MyPageReceivedReviewDTO;
import com.market.dto.StoreDTO;

import com.market.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
	}

	public List<MemberDTO> selectAllMembers() {
		return mapper.selectAllMembers();
	}

	public List<MemberDTO> searchMembers(Map<String, String> params) {
		return mapper.searchMembers(params);
	}

	public int updateMember(MemberDTO dto) {
		return mapper.updateMember(dto);
	}

	public int deleteMember(String memberId) {
		return mapper.deleteMember(memberId);
	}

	public List<StoreDTO> storeInfo(String memberId) {
		return mapper.storeInfo(memberId);
	}

	public int profileNo(String memberId) {
		return mapper.profileNo(memberId);
	}

	public String profilePath(int profileNo) {
		return mapper.profilePath(profileNo);
	}

	public List<String> buyerProfileNo(List<String> buyerIds) {
		return mapper.buyerProfileNo(buyerIds);
	}

	public List<Map<String, Object>> buyerProfilePath(List<String> buyerProfileNo) {
		return mapper.buyerProfilePath(buyerProfileNo);
	}

	public int insertFollow(String buyerId, String sellerId) {
		Map<String, Object> map = new HashMap<>();
		map.put("buyerId", buyerId);
		map.put("sellerId", sellerId);
		return mapper.insertFollow(map);
	}

	public int deleteFollow(String buyerId, String sellerId) {
		Map<String, Object> map = new HashMap<>();
		map.put("buyerId", buyerId);
		map.put("sellerId", sellerId);
		return mapper.deleteFollow(map);
	}

	public List<MemberAddressDTO> selectMemberAddress(String memberId) {
		return mapper.selectMemberAddress(memberId);
	}

	public int insertMemberAddress(MemberAddressDTO dto) {
		return mapper.insertMemberAddress(dto);
	}

	public int currentAddressNO() {
		return mapper.currentAddressNO();
	}

	public int deleteMemberAddress(int memberAddressNo) {
		return mapper.deleteMemberAddress(memberAddressNo);
	}

	public int changeMainAddressExisting(MemberAddressDTO dto) {
		return mapper.changeMainAddressExisting(dto);
	}

	public int changeMainAddressNew(MemberAddressDTO dto) {
		return mapper.changeMainAddressNew(dto);
	}

	public List<String> selectFollowStatus(String memberId) {
		return mapper.selectFollowStatus(memberId);
	}

	public List<MyPageProfileDTO> myPageProfile(String memberId) {
		return mapper.myPageProfile(memberId);
	}

	public List<MyPageMyInfoDTO> myPageMyInfo(String memberId) {
		return mapper.myPageMyInfo(memberId);
	}

	public int updateMyInfo(MyPageMyInfoDTO dto) {
		return mapper.updateMyInfo(dto);
	}
}