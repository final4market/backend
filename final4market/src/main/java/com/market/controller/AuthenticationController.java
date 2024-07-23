package com.market.controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.market.models.Member;
import com.market.dto.MemberDTO;
import com.market.service.AuthenticationService;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<MemberDTO> registerMember(@RequestBody MemberDTO memberDTO) {
    	String encodedPassword = passwordEncoder.encode(memberDTO.getMemberPasswd());

        Member member = new Member(
                memberDTO.getMemberId(),
                memberDTO.getMemberName(),
                encodedPassword,
                memberDTO.getMemberEmail(),
                memberDTO.getMemberPhoneNo()
        );

  
        Member savedMember = authService.registerMember(member);
        MemberDTO savedMemberDTO = new MemberDTO(savedMember);

        return ResponseEntity.ok(savedMemberDTO);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
    	LOGGER.info("로그인에 사용된 PasswordEncoder 타입은 다음과 같습니다: {}", passwordEncoder.getClass().getSimpleName());
        String memberId = loginRequest.get("memberId");
        String memberPasswd = loginRequest.get("memberPasswd");

        String token = authService.login(memberId, memberPasswd);
        if (token != null) {
        	Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(403).body("유효하지 않은 인증 정보");
        }
    }

    @PutMapping("/updatePassword")
    public void updatePassword(@RequestBody MemberDTO memberDTO) {
        authService.updatePassword(memberDTO.getMemberId(), memberDTO.getMemberPasswd());
    }
    
}
