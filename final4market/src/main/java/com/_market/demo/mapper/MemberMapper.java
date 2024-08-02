package com._market.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com._market.demo.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	List<MemberDTO> selectAllMember();
}