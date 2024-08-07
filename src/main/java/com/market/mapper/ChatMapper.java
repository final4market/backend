package com.market.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.ChatDTO;

@Mapper
public interface ChatMapper {
	List<ChatDTO> selectAllChat();

	List<ChatDTO> selectChatRoom(String memberId);

	List<ChatDTO> selectChatInfo(int chatNo);

	List<ChatDTO> chatRoomExist(Map<String, Object> map);

	int createChatRoom(ChatDTO dto);

	int nextChatNo();

	int nextMessageNo();

	int insertMessage(ChatDTO messageDto);

	ChatDTO selectImageFile(String imagePath);
}