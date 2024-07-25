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

import com.market.dto.ChatDTO;
import com.market.dto.MemberDTO;
import com.market.dto.MemberProfileDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ProductLikeDTO;
import com.market.dto.ReviewDTO;
import com.market.service.MemberService;
import com.market.service.ProductService;
import com.market.service.ReviewService;

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
	}

	@GetMapping("product/{productNo}/chat")
	public List<ChatDTO> selectProductChat(@PathVariable int productNo) {
		return productService.selectProductChat(productNo);

	}
}