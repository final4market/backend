package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.market.dto.ProductImageDTO;
import com.market.mapper.ImageMapper;

@Service
public class ImageService {
	private ImageMapper mapper;

	public ImageService(ImageMapper mapper) {
		this.mapper = mapper;
	}

	public List<ProductImageDTO> selectAllImage() {
		return mapper.selectAllImage();
	}
}