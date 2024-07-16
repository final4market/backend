package com._market.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._market.demo.dto.MemberDTO;
import com._market.demo.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper memberMapper;	
	
	public MemberService(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	public List<MemberDTO> selectAllMembers() {
		return memberMapper.selectAllMembers();
	}

	public List<MemberDTO> searchMembers(Map<String, String> params) {
		return memberMapper.searchMembers(params);
	}

	public int updateMember(MemberDTO dto) {
        return memberMapper.updateMember(dto);
    }

	public int deleteMember(String memberId) {
        return memberMapper.deleteMember(memberId);
    }
	
}
