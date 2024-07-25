package com.market.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.market.dto.ChatDTO;
import com.market.mapper.ChatMapper;

@Service
public class ChatService {
	private ChatMapper mapper;

	public ChatService(ChatMapper mapper) {
		this.mapper = mapper;
	}

	public List<ChatDTO> selectAllChat() {
		return mapper.selectAllChat();
	}

	public List<ChatDTO> selectChatRoom(String memberId) {
		return mapper.selectChatRoom(memberId);
	}

	public List<ChatDTO> selectChatInfo(String memberId) {
		return mapper.selectChatInfo(memberId);
	}
}