package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.dto.ProfileImageDTO;
import com.market.mapper.ProfileMapper;

@Service
public class ProfileService {
	private ProfileMapper mapper;

	public ProfileService(ProfileMapper mapper) {
		this.mapper = mapper;
	}

	public List<ProfileImageDTO> selectAllProfile() {
		return mapper.selectAllProfile();
	}
}