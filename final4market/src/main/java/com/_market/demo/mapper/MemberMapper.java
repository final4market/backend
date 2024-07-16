package com._market.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com._market.demo.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	List<MemberDTO> selectAllMembers();

	List<MemberDTO> searchMembers(Map<String, String> params);

	int updateMember(MemberDTO dto);

	int deleteMember(String memberId);

}
