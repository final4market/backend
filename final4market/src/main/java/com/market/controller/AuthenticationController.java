package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.market.models.Member;
import com.market.dto.MemberDTO;
import com.market.service.MemberService;
import com.market.service.AuthenticationService;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authService;
    
    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/preRegister")
    public ResponseEntity<?> preRegister(@RequestBody MemberDTO memberDTO) {
        String memberName = memberDTO.getMemberName();
        String memberPhoneNo = memberDTO.getMemberPhoneNo();
        
        Map<String, String> params = new HashMap<>();
        params.put("memberName", memberName);
        params.put("memberPhoneNo", memberPhoneNo);
        
        List<MemberDTO> members = memberService.searchMembers(params);

        if (!members.isEmpty()) {
            return ResponseEntity.status(409).body("이미 가입된 전화번호입니다");
        } else {
            return ResponseEntity.ok("회원 가입을 계속해주세요");
        }
    }
    
    @PostMapping("/checkIdAvailability")
    public ResponseEntity<Map<String, Object>> checkIdAvailability(@RequestBody Map<String, String> params) {
        boolean idExists = memberService.isMemberIdExists(params.get("memberId"));
        
        Map<String, Object> response = new HashMap<>();
        response.put("exists", idExists);
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/registerMember")
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
   
    @PostMapping("/recoverId")
    public ResponseEntity<Map<String, Object>> recoverId(@RequestBody Map<String, String> params) {
        String memberName = params.get("memberName");
        String memberPhoneNo = params.get("memberPhoneNo");

        // 아이디 찾기
        String memberId = memberService.findMemberIdByNameAndPhone(memberName, memberPhoneNo);

        Map<String, Object> response = new HashMap<>();
        
        if (memberId != null) {
            response.put("memberId", memberId);
            response.put("message", "아이디 검색 성공");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "존재하지 않는 회원");
            return ResponseEntity.status(404).body(response);
        }
    }
    
    @PostMapping("/checkMemberMatch")
    public ResponseEntity<?> searchMemberForPasswordReset(@RequestBody MemberDTO memberDTO) {
        String memberId = memberDTO.getMemberId();
        String memberName = memberDTO.getMemberName();
        String memberPhoneNo = memberDTO.getMemberPhoneNo();
        
        LOGGER.debug("Starting member search for password reset");
        LOGGER.debug("Member ID: {}", memberId);
        LOGGER.debug("Member Name: {}", memberName);
        LOGGER.debug("Member Phone Number: {}", memberPhoneNo);
        
        Map<String, String> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("memberName", memberName);
        params.put("memberPhoneNo", memberPhoneNo);
        
        List<MemberDTO> members = memberService.checkMemberMatch(params);

        if (!members.isEmpty()) {
            return ResponseEntity.ok("일치하는 회원 정보 있음. 비밀번호 재설정으로 연결합니다");
        } else {
            return ResponseEntity.status(404).body("일치하는 회원 정보 없음");
        }
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestBody MemberDTO memberDTO) {
        String memberId = memberDTO.getMemberId();
        String newPasswd = memberDTO.getMemberPasswd();

        // 현재 회원 정보 가져오기
        Member member = memberService.getMemberById(memberId);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("일치하는 회원 정보 없음");
        }

        // 새로운 비밀번호가 기존 비밀번호와 같은지 조회
        if (passwordEncoder.matches(newPasswd, member.getMemberPasswd())) {
            return ResponseEntity.badRequest().body("직전 비밀번호와 동일한 비밀번호를 사용할 수 없습니다. 새로운 비밀번호를 입력해주세요.");
        }

        // 새로운 비밀번호가 기존 비밀번호와 같지 않은 경우 새로운 비밀번호로 업데이트
        String encodedPassword = passwordEncoder.encode(newPasswd);
        member.setMemberPasswd(encodedPassword);
        memberService.updateMemberEntity(member);

        return ResponseEntity.ok("비밀번호 수정 성공");
    }
    
}
