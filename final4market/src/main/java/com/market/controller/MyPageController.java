package com.market.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.market.dto.ChatDTO;
import com.market.dto.MemberDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ReviewDTO;
import com.market.dto.MemberProfileDTO;
import com.market.dto.ProductLikeDTO;
import com.market.dto.ProfileImageDTO;
import com.market.service.ChatService;
import com.market.service.MemberService;
import com.market.service.ProductService;
import com.market.service.ReviewService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyPageController {
	private ChatService chatService;
	private MemberService memberService;
	private ProductService productService;
	private ReviewService reviewService;

	public MyPageController(ChatService chatService, MemberService memberService,
			ProductService productService, ReviewService reviewService) {
		this.chatService = chatService;
		this.memberService = memberService;
		this.productService = productService;
		this.reviewService = reviewService;
	}

	@GetMapping("/chat/list")
	public List<ChatDTO> selectAllChat() {
		return chatService.selectAllChat();
	}

	@GetMapping("/member/list")
	public List<MemberDTO> selectAllMembers() {
		return memberService.selectAllMembers();
	}

	@GetMapping("/member/product/list")
	public List<ProductDTO> selectSellerAllProduct() {
		return productService.selectSellerAllProduct();
	}

	@GetMapping("/image/list")
	public List<ProductImageDTO> selectAllProductImage() {
		return productService.selectAllProductImage();
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


	@GetMapping("product/{productNo}/chat")
	public List<ChatDTO> selectProductChat(@PathVariable int productNo) {
		return productService.selectProductChat(productNo);
	}
}