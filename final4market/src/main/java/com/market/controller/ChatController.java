package com.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.ChatDTO;
import com.market.service.ChatService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatController {

    private final ChatService chatService;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public ChatController(ChatService chatService, SimpMessagingTemplate messagingTemplate) {
        this.chatService = chatService;
        this.messagingTemplate = messagingTemplate;
    }

    //로그인한 사용자 채팅방 목록 조회
    @GetMapping("/selectChatRoom")
    public List<ChatDTO> selectChatRoom(@RequestParam("memberId") String memberId) {
        List<ChatDTO> list = chatService.selectChatRoom(memberId);
        return list;
    }

    //해당 채팅방 대화 내용 조회
    @GetMapping("/selectChatInfo")
    public List<ChatDTO> selectChatInfo(@RequestParam("chatNo") int chatNo) {
        List<ChatDTO> list = chatService.selectChatInfo(chatNo);
        return list;
    }
    
    //서브페이지에서 대화를 시도할때 채팅방 존재 유무
    @GetMapping("/chatRoomExist")
    public List<ChatDTO> chatRoomExist(@RequestParam("memberId") String memberId, @RequestParam("productNo") int productNo) {
        List<ChatDTO> list = chatService.chatRoomExist(memberId, productNo);
        return list;
    }

    @PostMapping("/createChatRoom")
    public int createChatRoom(@RequestBody ChatDTO dto) {
        int nextChatNo = chatService.nextChatNo();
        dto.setChatNo(nextChatNo);
        int row = chatService.createChatRoom(dto);
        return row;  // Return the row count or a status indicating success
    }
    

    // WebSocket으로 채팅 메시지 수신 및 저장
    @MessageMapping("/message")
    public ResponseEntity<String> receiveMessage(@RequestBody ChatDTO messageDto) {
        // 메시지 저장 (옵션)
        int nextMessageNo = chatService.nextMessageNo();
        messageDto.setMessageNo(nextMessageNo);
        System.out.println(messageDto);
        chatService.insertMessage(messageDto);
        // 메시지를 해당 채팅방 구독자들에게 전송
        messagingTemplate.convertAndSend("/sub/chatroom/" + messageDto.getChatNo(), messageDto);
        return ResponseEntity.ok("메시지 전송 완료");
    }
}

