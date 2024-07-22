package com.market.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.ChatDTO;
import com.market.dto.MemberDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ProfileImageDTO;
import com.market.dto.ReviewDTO;
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

	@GetMapping("/member/ProductPurchaseHistory/{buyerId}")
	public List<ProductDTO> ProductPurchaseHistory(@PathVariable String buyerId) {
		return productService.ProductPurchaseHistory(buyerId);	
	}
	
	@GetMapping("/member/productSales/list/{memberId}")
	public List<ProductDTO> productSalesList(@PathVariable String memberId) {
		return productService.productSaleslist(memberId);	
	}
	
	
	@GetMapping("/image/list")
	public List<ProductImageDTO> selectAllProductImage() {
		return productService.selectAllProductImage();
	}
	
	@GetMapping("/profile/list")
	public List<ProfileImageDTO> selectAllProfileImage() {
		return memberService.selectAllProfileImage();
	}

	@PostMapping("/review/insert")
	public Map<String, Object> insertReview(@RequestParam Map<String, String> params) {
	    Map<String, Object> map = new HashMap<>();
	    try {
	    	 System.out.println("Received params: " + params);
	        ReviewDTO dto = new ReviewDTO();

	        dto.setProductNo(Integer.parseInt(params.get("productNo")));
	        dto.setBuyerId(params.get("buyerId"));
	        dto.setSellerId(params.get("sellerId"));
	        dto.setReview(params.get("reviewText"));
	        dto.setReviewScore(Integer.parseInt(params.get("reviewScore")));

	        reviewService.insertReview(dto);
	        map.put("msg", "상품 등록 성공");
	        map.put("result", true);
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	        map.put("msg", "입력 값 오류 다시입력해세요: " + e.getMessage());
	        map.put("result", false);
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put("msg", "상품 등록 실패");
	        map.put("result", false);
	    }
	    return map;
	}


	}
