package com.market.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.market.dto.MemberDTO;
import com.market.dto.StoreDTO;
import com.market.mapper.MemberMapper;

@Service
public class UserService {
	private final MemberMapper mapper;

	public UserService(MemberMapper mapper) {
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
}