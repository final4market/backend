package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.dto.MemberDTO;
import com.market.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
	}

	public List<MemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}
}