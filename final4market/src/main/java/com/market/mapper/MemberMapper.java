package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	List<MemberDTO> selectAllMember();
}