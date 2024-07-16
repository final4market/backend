package com._market.demo.controller;

import com._market.demo.dto.MemberDTO;
import com._market.demo.service.MemberService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<MemberDTO> members = memberService.selectAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/admin/search")
    public ResponseEntity<List<MemberDTO>> searchMembers(@RequestParam Map<String, String> params) {
        List<MemberDTO> members = memberService.searchMembers(params);
        return ResponseEntity.ok(members);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<Map<String, Object>> updateMember(@RequestBody MemberDTO dto) {
        int count = memberService.updateMember(dto);        
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("msg", count == 0 ? "회원정보 수정 실패" : "회원정보 수정 성공");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/admin/{memberId}")
    public ResponseEntity<Map<String, Object>> deleteMember(@PathVariable String memberId) {
        int count = memberService.deleteMember(memberId);
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("msg", count == 0 ? "회원정보 삭제 실패" : "회원정보 삭제 성공");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
