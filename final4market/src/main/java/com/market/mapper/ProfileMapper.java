package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.ProfileImageDTO;

@Mapper
public interface ProfileMapper {
	List<ProfileImageDTO> selectAllProfile();
}