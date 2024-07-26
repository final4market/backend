package com.market.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.MyPageProductDTO;
import com.market.dto.MyPageProfileDTO;
import com.market.service.MemberService;
import com.market.service.ProductService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyPageController {
	private MemberService memberService;
	private ProductService productService;

	public MyPageController(MemberService memberService, ProductService productService) {
		this.memberService = memberService;
		this.productService = productService;
	}

	@GetMapping("/myPageProfile/{memberId}")
	public MyPageProfileDTO myPageProfile(@PathVariable String memberId) {
		return memberService.myPageProfile(memberId);
	}

	@GetMapping("/myPageProduct/{memberId}")
	public List<MyPageProductDTO> myPageProduct(@PathVariable String memberId) {
		return productService.myPageProduct(memberId);
	}
}