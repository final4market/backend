package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.MyPageMyInfoDTO;
import com.market.dto.MyPageProductDTO;
import com.market.dto.MyPageProfileDTO;
import com.market.dto.MyPageReceivedReviewDTO;
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

	@GetMapping("/api/member/myPageMyInfo/{memberId}")
	public List<MyPageMyInfoDTO> myPageMyInfo(@PathVariable String memberId) {
		return memberService.myPageMyInfo(memberId);
	}

	@GetMapping("api/product/myPageInterestProduct/{memberId}")
	public List<MyPageProductDTO> myPageInterestProduct(@PathVariable String memberId) {
		return productService.myPageInterestProduct(memberId);
	}
	
	@PutMapping("/api/member/myPageMyInfo/update")
	public ResponseEntity<Map<String, Object>> updateMyInfo(@RequestBody MyPageMyInfoDTO dto) {
//		System.out.println("updateMyInfo : " + dto);
		int count = memberService.updateMyInfo(dto);
		Map<String, Object> map = new HashMap<>();
		map.put("count", count);
		map.put("msg", count == 0 ? "회원 정보 수정 실패" : "회원 정보 수정 성공");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/api/product/myPageReceivedReview/{memberId}")
	public List<MyPageReceivedReviewDTO> myPageReceivedReview(@PathVariable String memberId) {
		return productService.myPageReceivedReview(memberId);
	}
}