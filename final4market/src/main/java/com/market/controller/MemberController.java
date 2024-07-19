package com.market.controller;


import com.market.dto.MemberDTO;
import com.market.service.MemberService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.StoreDTO;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*" )
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> selectAllMembers() {
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
    
    @GetMapping("/storeInfo")
	public List<StoreDTO> storeInfo(String memberId) {
//	    System.out.println(memberId);
	    List<StoreDTO> list = memberService.storeInfo(memberId);
	    return list;
	}

	@GetMapping("/sellerProfile")
	public String sellerProfile(String memberId) {
	    int profileNo = memberService.profileNo(memberId);
	    String profilePath = memberService.profilePath(profileNo);
	    return profilePath;
	}
	
	@PostMapping("/buyerProfile")
	public List<Map<String, Object>> buyerProfile(@RequestBody Map<String, Object> memberId) {
		List<String> buyerIds = (List<String>) memberId.get("memberId");
		List<String> buyerProfileNo = memberService.buyerProfileNo(buyerIds);
		List<Map<String, Object>> buyerProfilePath = memberService.buyerProfilePath(buyerProfileNo);
//		System.out.println(buyerProfilePath);
		return buyerProfilePath;
	}	

}
