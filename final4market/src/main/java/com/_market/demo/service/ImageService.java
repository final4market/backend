package com._market.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com._market.demo.dto.ImageDTO;
import com._market.demo.mapper.ImageMapper;

@Service
public class ImageService {
	private ImageMapper mapper;

	public ImageService(ImageMapper mapper) {
		this.mapper = mapper;
	}

	public List<ImageDTO> selectAllImage() {
		return mapper.selectAllImage();
	}
}