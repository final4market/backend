package com._market.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com._market.demo.dto.ProfileDTO;

@Mapper
public interface ProfileMapper {
	List<ProfileDTO> selectAllProfile();
}