package com.market.controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.ChatDTO;
import com.market.service.ChatService;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*" )
public class ChatController {
	
	private ChatService chatService;
	
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}

	@GetMapping("/selectChatRoom")
	public List<ChatDTO> selectChatRoom(String memberId){
		List<ChatDTO> list = chatService.selectChatRoom(memberId);
		System.out.println(list);
		return list;
	}
	@GetMapping("/selectChatInfo")
	public List<ChatDTO> selectChatInfo(String memberId){
		List<ChatDTO> list = chatService.selectChatInfo(memberId);
		System.out.println(list);
		return list;
	}
}
