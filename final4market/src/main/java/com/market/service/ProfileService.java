package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.dto.ProfileDTO;
import com.market.mapper.ProfileMapper;

@Service
public class ProfileService {
	private ProfileMapper mapper;

	public ProfileService(ProfileMapper mapper) {
		this.mapper = mapper;
	}

	public List<ProfileDTO> selectAllProfile() {
		return mapper.selectAllProfile();
	}
}