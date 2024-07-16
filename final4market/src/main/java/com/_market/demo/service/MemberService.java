package com._market.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com._market.demo.dto.MemberDTO;
import com._market.demo.mapper.MemberMapper;

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
	
}
