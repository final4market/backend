package com.market.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.ChatDTO;
import com.market.dto.ImageDTO;
import com.market.dto.MemberDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProfileDTO;
import com.market.dto.ReviewDTO;
import com.market.service.ChatService;
import com.market.service.ImageService;
import com.market.service.MemberService;
import com.market.service.ProductService;
import com.market.service.ProfileService;
import com.market.service.ReviewService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyPageController {
	private ChatService chatService;
	private ImageService imageService;
	private MemberService memberService;
	private ProductService productService;
	private ProfileService profileService;
	private ReviewService reviewService;

	public MyPageController(ChatService chatService, ImageService imageService, MemberService memberService,
			ProductService productService, ProfileService profileService, ReviewService reviewService) {
		this.chatService = chatService;
		this.imageService = imageService;
		this.memberService = memberService;
		this.productService = productService;
		this.profileService = profileService;
		this.reviewService = reviewService;
	}

	@GetMapping("/chat/list")
	public List<ChatDTO> selectAllChat() {
		return chatService.selectAllChat();
	}

	@GetMapping("/image/list")
	public List<ImageDTO> selectAllImage() {
		return imageService.selectAllImage();
	}

	@GetMapping("/member/list")
	public List<MemberDTO> selectAllMember() {
		return memberService.selectAllMember();
	}

	@GetMapping("/product/list")
	public List<ProductDTO> selectAllProduct() {
		return productService.selectAllProduct();
	}

	@GetMapping("/profile/list")
	public List<ProfileDTO> selectAllProfile() {
		return profileService.selectAllProfile();
	}

	@GetMapping("/review/list")
	public List<ReviewDTO> selectAllReview() {
		return reviewService.selectAllReview();
	}
}