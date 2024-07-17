package com.market.controller;

import com.market.dto.MemberDTO;
import com.market.service.MemberService;

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
    private MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> selectAllMembers() {
        List<MemberDTO> members = service.selectAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/admin/search")
    public ResponseEntity<List<MemberDTO>> searchMembers(@RequestParam Map<String, String> params) {
        List<MemberDTO> members = service.searchMembers(params);
        return ResponseEntity.ok(members);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<Map<String, Object>> updateMember(@RequestBody MemberDTO dto) {
        int count = service.updateMember(dto);        
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("msg", count == 0 ? "회원정보 수정 실패" : "회원정보 수정 성공");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/admin/{memberId}")
    public ResponseEntity<Map<String, Object>> deleteMember(@PathVariable String memberId) {
        int count = service.deleteMember(memberId);
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("msg", count == 0 ? "회원정보 삭제 실패" : "회원정보 삭제 성공");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
