package com.market.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.ChatDTO;
import com.market.dto.MemberDTO;
import com.market.dto.MemberProfileDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ProductLikeDTO;
import com.market.dto.ReviewDTO;
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

	@GetMapping("/member/{memberProfileNo}/profile")
	public List<MemberProfileDTO> selectMemberProfile(@PathVariable int memberProfileNo) {
		return memberService.selectMemberProfile(memberProfileNo);
	}

	@GetMapping("/member/{memberId}/nick")
	public List<MemberDTO> selectMemberNick(@PathVariable String memberId) {
		return memberService.selectMemberNick(memberId);
	}

	@GetMapping("/member/{memberId}/score")
	public List<ReviewDTO> selectMemberScore(@PathVariable String memberId) {
		return memberService.selectMemberScore(memberId);
	}

	@GetMapping("/product/{productNo}/image")
	public List<ProductImageDTO> selectProductImage(@PathVariable int productNo) {
		return productService.selectProductImage(productNo);
	}

	@GetMapping("/product/{productNo}/price")
	public List<ProductDTO> selectProductPrice(@PathVariable int productNo) {
		return productService.selectProductPrice(productNo);
	}

	@GetMapping("product/{productNo}/like")
	public List<ProductLikeDTO> selectProductLike(@PathVariable int productNo) {
		return productService.selectProductLike(productNo);

	@GetMapping("product/{productNo}/chat")
	public List<ChatDTO> selectProductChat(@PathVariable int productNo) {
		return productService.selectProductChat(productNo);
	}
}