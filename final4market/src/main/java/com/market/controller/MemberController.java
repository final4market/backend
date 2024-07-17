package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.StoreDTO;
import com.market.service.MemberService;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*" )
public class MemberController {
	MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/storeInfo")
	public List<StoreDTO> storeInfo(String memberId) {
	    System.out.println(memberId);
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
	public String buyerProfile(@RequestBody List<String> memberId) {
		System.out.println(memberId);
		return null;
	}

}
