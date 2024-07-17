package com.market.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.market.dto.MemberDTO;
import com.market.dto.ProfileImageDTO;
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

	public List<ProfileImageDTO> selectAllProfileImage() {
		return mapper.selectAllProfileImage();
	}
}
