package com.market.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<ChatDTO> selectChatInfo(int chatNo) {
		return mapper.selectChatInfo(chatNo);
	}

	public List<ChatDTO> chatRoomExist(String memberId, int productNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("productNo", productNo);
		return mapper.chatRoomExist(map);
	}

	public int createChatRoom(ChatDTO dto) {
		return mapper.createChatRoom(dto);
	}

	public int nextChatNo() {
		return mapper.nextChatNo();
	}

	public int nextMessageNo() {
		return mapper.nextMessageNo();
	}

	public int insertMessage(ChatDTO messageDto) {
		return mapper.insertMessage(messageDto);
	}

	public ChatDTO selectImageFile(String imagePath) {
		return mapper.selectImageFile(imagePath);
	}
}