package com._market.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com._market.demo.dto.ProfileDTO;
import com._market.demo.mapper.ProfileMapper;

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