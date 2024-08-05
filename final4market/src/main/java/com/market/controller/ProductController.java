package com.market.controller;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.market.dto.CategoryDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.MyPageReceivedReviewDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;

import com.market.dto.ProductPreviewDTO;

import com.market.models.ProductImage;

import com.market.dto.SellerPageProductDTO;
import com.market.dto.SellerPageReceivedReviewDTO;
import com.market.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*" )
public class ProductController {
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/api/product/productImage")
	public List<ProductImageDTO> productImage(@RequestParam("productNo") int productNo) {
		List<ProductImageDTO> list = productService.productImage(productNo);
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/api/product/productInfo")
	public ProductDTO productInfo(@RequestParam("productNo") int productNo) {
		ProductDTO dto = productService.productInfo(productNo);
		return dto; 
	}
	
	@GetMapping("/api/product/deliveryInfo")
	public DeliveryDTO deliveryInfo(@RequestParam("productNo") int productNo) {
		DeliveryDTO dto = productService.deliveryInfo(productNo);
		System.out.println(dto);
		return dto; 
	}
	
	@GetMapping("/api/product/categoryInfo")
	public List<CategoryDTO> categoryInfo(@RequestParam("categoryNo") int categoryNo) {
		List<CategoryDTO> list = productService.categoryInfo(categoryNo);
		return list; 
	}
	

	@GetMapping("/api/product/category/list")
	public List<CategoryDTO> selectAllCategory() {
		return productService.selectAllCategory();
	}
	@GetMapping("/category/list/{parNum}")
	public List<CategoryDTO> selectParentCategory(@PathVariable int parNum) {
		return productService.selectParentCategory(parNum);
	}
	

	
	@PostMapping("/product/update/{productNo}")
	public Map<String, Object> updateProduct(@RequestParam Map<String, String> params,
			@PathVariable int productNo,
            @RequestParam(value = "imageKey0", required = false) String imageKey0,
            @RequestParam(value = "imageKey1", required = false) String imageKey1,
            @RequestParam(value = "imageKey2", required = false) String imageKey2) throws NumberFormatException {
Map<String, Object> map = new HashMap<>();
try {
ProductDTO dto = new ProductDTO();
dto.setProductTitle(params.get("productTitle"));
dto.setProductPrice(Integer.parseInt(params.get("productPrice")));
dto.setCategoryNo(Integer.parseInt(params.get("categoryNo")));
dto.setProductContent(params.get("productContent"));
dto.setProductStatus(params.get("productStatus"));
dto.setMemberId(params.get("memberId"));
dto.setProductNo(productNo);


// deliveryCharge 값이 null일 경우를 처리

String deliveryChargeStr = params.get("deliveryCharge");
dto.setDeliveryCharge(deliveryChargeStr != null && !deliveryChargeStr.isEmpty() ? Integer.parseInt(deliveryChargeStr) : 0);

String deliveryNoStr = params.get("deliveryNo");
if (deliveryNoStr != null && !deliveryNoStr.isEmpty()) {
dto.setDeliveryNo(Integer.parseInt(deliveryNoStr));
} else {
dto.setDeliveryNo(0);
}

String tradeArea = params.get("tradeArea");
if (tradeArea != null && !tradeArea.isEmpty()) {
dto.setTradeArea(tradeArea);
} else {
dto.setTradeArea("0");
}




map.put("msg", "상품 수정 성공");
map.put("result", true);
map.put("productNo", productNo);
} catch (IllegalArgumentException e) {
e.printStackTrace();
map.put("msg", "입력 값 오류 다시 입력해 주세요: " + e.getMessage());
map.put("result", false);
} catch (Exception e) {
e.printStackTrace();
map.put("msg", "상품 수정 실패");
map.put("result", false);
}
return map;
}

	
	
	


	@GetMapping("/insertProductLike")
	public Map<String, Object> productLike(@RequestParam("memberId") String memberId, @RequestParam("productNo") int productNo) {
		Map<String, Object> map = new HashMap<>();
		try {			
			productService.insertProductLike(memberId, productNo);
			map.put("msg", "좋아요를 하셨습니다");
		} catch (Exception e) {
			productService.deleteProductLike(memberId, productNo);
			map.put("msg", "좋아요를 취소하셨습니다");
			return map;
		}
		
		
		return map;
	}
	

	

	
	@GetMapping("/api/product/categoryProductInfo")
	public List<ProductDTO> categoryProductInfo(@RequestParam("categoryNo") int categoryNo){
		
		List<ProductDTO> list = productService.categoryProductInfo(categoryNo);
		
		return list;
	}


	  @GetMapping("/api/product/search")
	    public List<ProductDTO> searchResult(
	        @RequestParam(required = false) String minPrice,
	        @RequestParam(required = false) String maxPrice,
	        @RequestParam(required = false) String includeSoldOut,
	        @RequestParam(required = false) String sortOrder,
	        @RequestParam(required = false) String searchQuery,
	        @RequestParam(required = false) String categoryNo,
	        @RequestParam(required = false) String parentCategoryNo
	    ) {
	        return productService.searchResult(minPrice, maxPrice, includeSoldOut, sortOrder, searchQuery, categoryNo, parentCategoryNo);
	    }
  

	  @GetMapping("/api/product/{productNo}/images")
	  public List<ProductImage> updateProductImages(@PathVariable int productNo ) {
	  	return productService.updateloadProductImages(productNo);
	  }


	
	@PostMapping("/insertTransaction")
	public void updateTransaction(@RequestParam("productNo") int productNo, @RequestParam("memberId") String memberId) {
		System.out.println(productNo);
		productService.insertTransaction(productNo, memberId);
	}

	@PutMapping("/productStatusUpdate")
    public String productStatusUpdate(@RequestParam("status") String status, @RequestParam("productNo") int productNo) {
		System.out.println(status);
        productService.productStatusUpdate(status,productNo);
        return null;
    }

    @PutMapping("/ProductStatusDelete")
    public void ProductStatusDelete(@RequestParam("productNo") int productNo) {

        productService.ProductStatusDelete(productNo);
    }
    
    @Transactional
    @GetMapping("/api/product/productPreview")
    public ResponseEntity<ProductPreviewDTO> getProductPreview(@RequestParam int productNo) {
        ProductPreviewDTO productPreview = productService.getProductPreview(productNo);
        return ResponseEntity.ok(productPreview);
    }


	@GetMapping("/api/product/sellerPageProduct/{sellerId}")
	public List<SellerPageProductDTO> sellerPageProduct(@PathVariable String sellerId) {
		return productService.sellerPageProduct(sellerId);
	}

	@GetMapping("/api/product/sellerReceivedReview/{sellerId}")
	public List<SellerPageReceivedReviewDTO> sellerPageReceivedReview(@PathVariable String sellerId) {
		return productService.sellerPageReceivedReview(sellerId);
	}
}