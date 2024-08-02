package com._market.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com._market.demo.dto.ChatDTO;
import com._market.demo.mapper.ChatMapper;

@Service
public class ChatService {
	private ChatMapper mapper;

	public ChatService(ChatMapper mapper) {
		this.mapper = mapper;
	}

	public List<ChatDTO> selectAllChat() {
		return mapper.selectAllChat();
	}
}