package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.dto.StoreDTO;
import com.market.mapper.MemberMapper;

@Service
public class MemberService {
	MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
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
	
	
}
