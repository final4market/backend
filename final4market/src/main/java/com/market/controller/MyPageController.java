package com.market.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.MyStoreProductDTO;
import com.market.dto.MyStoreProfileDTO;
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

	@GetMapping("/myStoreProfile/{memberId}")
	public MyStoreProfileDTO myStoreProfile(@PathVariable String memberId) {
		return memberService.myStoreProfile(memberId);
	}

	@GetMapping("/myStoreProduct/{productNo}")
	public MyStoreProductDTO myStoreProduct(@PathVariable int productNo) {
		return productService.myStoreProduct(productNo);
	}
}