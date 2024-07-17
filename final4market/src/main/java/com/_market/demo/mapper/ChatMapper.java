package com._market.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com._market.demo.dto.ChatDTO;

@Mapper
public interface ChatMapper {
	List<ChatDTO> selectAllChat();
}