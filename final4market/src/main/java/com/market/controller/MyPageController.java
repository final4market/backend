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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.MemberDTO;
import com.market.dto.MyPageFollowListDTO;
import com.market.dto.MyPageMyInfoDTO;
import com.market.dto.MyPageProductDTO;
import com.market.dto.MyPageProfileDTO;
import com.market.dto.MyPageReceivedReviewDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ReviewDTO;
import com.market.service.MemberService;
import com.market.service.ProductService;
import com.market.service.ReviewService;
import com.market.dto.MyPageFollowListDTO;
import com.market.dto.SellerPageProductDTO;
import com.market.dto.SellerPageReceivedReviewDTO;
import com.market.dto.MyPageReceivedReviewDTO;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyPageController {
	private MemberService memberService;
	private ProductService productService;
	private ReviewService reviewService;


	public MyPageController(MemberService memberService,
			ProductService productService, ReviewService reviewService) {
		this.memberService = memberService;
		this.productService = productService;
		this.reviewService = reviewService;
	}
	
	@GetMapping("/member/list")
	public List<MemberDTO> selectAllMembers() {
		return memberService.selectAllMembers();
	}

	
	@GetMapping("/image/list")
	public List<ProductImageDTO> selectAllProductImage() {
		return productService.selectAllProductImage();
	}
	

	@GetMapping("/member/ProductPurchaseHistory/{buyerId}")
	public List<ProductDTO> ProductPurchaseHistory(@PathVariable String buyerId) {
		return productService.ProductPurchaseHistory(buyerId);	
	}
	
	@GetMapping("/member/productsoldoutlist/list/{memberId}")
	public List<ProductDTO> productsoldoutlist(@PathVariable String memberId) {
		return productService.productsoldoutlist(memberId);	
	}
	
	@GetMapping("/member/productSaleslist/{memberId}")
	public List<ProductDTO> productList(@PathVariable String memberId) {
		return productService.productSaleslist(memberId);	
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
	        map.put("msg", "리뷰 등록 성공");
	        map.put("result", true);
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	        map.put("msg", "입력 값 오류 다시입력해세요: " + e.getMessage());
	        map.put("result", false);
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put("msg", "리뷰 등록 실패");
	        map.put("result", false);
	    }
	    return map;
	}

	@GetMapping("/review/productWroteList/{memberId}")
	public List<MemberDTO> productWroteList(@PathVariable String memberId) {
		return reviewService.productWroteList(memberId);	
	}
	
	@GetMapping("/review/wroteList/{productNo}")
	public List<MemberDTO> wroteReviewList(@PathVariable int productNo) {
		return reviewService.wroteReviewList(productNo);	
	}
	
	@DeleteMapping("/review/delete/{productNo}")
	public ResponseEntity<String> reviewDelete(@PathVariable int productNo) {
	    int result = reviewService.reviewDelete(productNo);
	    if (result > 0) {
	        return ResponseEntity.ok("삭제가 완료됐습니다.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("리뷰를 찾을 수 없습니다.");
	    }
	}
	
	@PutMapping("/product/delete/{productNo}")
	public ResponseEntity<String> productDelete(@PathVariable int productNo) {
	    int result = productService.productDelete(productNo);
	    if (result > 0) {
	        return ResponseEntity.ok("삭제가 완료됐습니다.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("상품을 찾을 수 없습니다.");
	    }
	}
	
	@PutMapping("/review/update/{productNo}")
	public Map<String, Object> reviewUpdate(
	    @PathVariable int productNo, 
	    @RequestBody ReviewDTO dto) {
	    Map<String, Object> map = new HashMap<>();
	    try {
	        System.out.println("받아온값:" + dto); // 받아온 데이터 확인
	        
	        // DTO에 값을 설정
	        dto.setProductNo(productNo);

	        // 리뷰 수정 서비스 호출
	        reviewService.updateReview(dto);
	        
	        map.put("msg", "리뷰 수정 성공");
	        map.put("result", true);
	    } catch (NumberFormatException e) {
	        map.put("msg", "입력된 값이 올바르지 않습니다.");
	        map.put("result", false);
	    } catch (Exception e) {
	        map.put("msg", "서버 오류가 발생했습니다.");
	        map.put("result", false);
	    }
	    return map;
	}
	

	@GetMapping("/product/{productNo}/image")
	public List<ProductImageDTO> selectProductImage(@PathVariable int productNo) {
		return productService.selectProductImage(productNo);
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

	@GetMapping("/api/product/myPageInterestProduct/{memberId}")
	public List<MyPageProductDTO> myPageInterestProduct(@PathVariable String memberId) {
		return productService.myPageInterestProduct(memberId);
	}
	
	@PutMapping("/api/member/myPageMyInfo/update")
	public ResponseEntity<Map<String, Object>> updateMyInfo(@RequestBody MyPageMyInfoDTO dto) {
		System.out.println("updateMyInfo : " + dto);
		int count = memberService.updateMyInfo(dto);
		Map<String, Object> map = new HashMap<>();
		map.put("count", count);
		map.put("msg", count == 0 ? "회원 정보 수정 실패" : "회원 정보 수정 성공");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/api/member/myPageReceivedReview/{memberId}")
	public List<MyPageReceivedReviewDTO> myPageReceivedReview(@PathVariable String memberId) {
		return memberService.myPageReceivedReview(memberId);
	}

	@GetMapping("/api/member/myPageFollowList/{memberId}")
	public List<MyPageFollowListDTO> myPageFollowList(@PathVariable String memberId) {
		return memberService.myPageFollowList(memberId);
	}
}