package com.market.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.MyPageInfoDTO;
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

	@GetMapping("/api/member/myPageProfile/{memberId}")
	public List<MyPageProfileDTO> myPageProfile(@PathVariable String memberId) {
		return memberService.myPageProfile(memberId);
	}

	@GetMapping("/api/product/myPageProduct/{memberId}")
	public List<MyPageProductDTO> myPageProduct(@PathVariable String memberId) {
		return productService.myPageProduct(memberId);
	}

	@GetMapping("/api/member/myPageInfo/{memberId}")
	public List<MyPageInfoDTO> myPageInfo(@PathVariable String memberId) {
		return memberService.myPageInfo(memberId);
	}

	@GetMapping("api/product/myPageInterest/{memberId}")
	public List<MyPageProductDTO> myPageInterest(@PathVariable String memberId) {
		return productService.myPageInterest(memberId);
	}
}