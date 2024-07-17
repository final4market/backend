package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.ProfileDTO;

@Mapper
public interface ProfileMapper {
	List<ProfileDTO> selectAllProfile();
}