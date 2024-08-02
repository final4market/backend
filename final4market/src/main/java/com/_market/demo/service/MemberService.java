package com._market.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com._market.demo.dto.MemberDTO;
import com._market.demo.mapper.MemberMapper;

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