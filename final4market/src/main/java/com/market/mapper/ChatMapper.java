package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.ChatDTO;

@Mapper
public interface ChatMapper {
	List<ChatDTO> selectAllChat();

	List<ChatDTO> selectChatRoom(String memberId);

	List<ChatDTO> selectChatInfo(String memberId);
}