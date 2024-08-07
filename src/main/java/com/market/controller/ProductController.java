package com.market.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.CategoryDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ProductPreviewDTO;
import com.market.dto.SellerPageProductDTO;
import com.market.dto.SellerPageReceivedReviewDTO;
import com.market.models.ProductImage;
import com.market.service.ProductService;



@RestController
@CrossOrigin(origins = "http://localhost:3000" , allowedHeaders = "*" )
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
	
	@GetMapping("/api/product/newproductlist")
	public List<ProductDTO> newproductlist() {
	return productService.newproductlist();
	}
	
	@GetMapping("/api/product/hotproductlist")
	public List<ProductDTO> hotproductlist() {
	return productService.hotproductlist();
	}
	
	@GetMapping("/api/product/category/list")
	public List<CategoryDTO> selectAllCategory() {
		return productService.selectAllCategory();
	}

	@GetMapping("/api/product/category/list/{parNum}")
	public List<CategoryDTO> selectParentCategory(@PathVariable int parNum) {
		return productService.selectParentCategory(parNum);
	}
	
	
	@GetMapping("/api/product/update/view/{productNo}")
	public ProductDTO productUpdate(@PathVariable int productNo ) {
	    return productService.productUpdate(productNo);
	   
	}
	

	@PostMapping("/product/insert")
	public Map<String, Object> insertProduct(@RequestParam Map<String, String> params,
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

	        int productNo = productService.getProductNo();
	        dto.setProductNo(productNo);

	        productService.insertProduct(dto);

	        // Save images with numbering
	        String baseUrl = "https://lucky4market-imgsrvr.s3.ap-northeast-2.amazonaws.com/";
	        List<String> imageKeys = Arrays.asList(imageKey0, imageKey1, imageKey2).stream()
	            .filter(key -> key != null && !key.isEmpty())
	            .map(key -> baseUrl + key)  // Prepend base URL to each image key
	            .collect(Collectors.toList());
	        System.out.println("저장"+imageKeys);

	        
	        productService.saveProductImages(productNo, imageKeys);

	        map.put("msg", "상품 등록 성공");
	        map.put("result", true);
	        map.put("productNo", productNo);
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	        map.put("msg", "입력 값 오류 다시 입력해 주세요: " + e.getMessage());
	        map.put("result", false);
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put("msg", "상품 등록 실패");
	        map.put("result", false);
	    }
	    return map;
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



productService.updateProduct(dto);


// Save images with numbering
String baseUrl = "https://lucky4market-imgsrvr.s3.ap-northeast-2.amazonaws.com/";
List<String> imageKeys = Arrays.asList(imageKey0, imageKey1, imageKey2).stream()
    .filter(key -> key != null && !key.isEmpty())
    .map(key -> baseUrl + key)  // Prepend base URL to each image key
    .collect(Collectors.toList());



productService.updateProductImages(productNo, imageKeys);


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

	
	@DeleteMapping("/product/deleteImage/{productNo}/{deleteImages}")
    public int deleteProductImage(@PathVariable int productNo, @PathVariable String deleteImages) {
        // 쉼표로 구분된 이미지 번호를 리스트로 변환
        List<String> imageList = Arrays.asList(deleteImages.split(","));

        // 삭제 로직 구현
        for (String imageNo : imageList) {
            System.out.println("삭제할 이미지: " + productNo + " and imageNo: " + imageNo);
            productService.deleteProductImages(productNo,imageNo);
            // 여기서 실제 삭제 로직을 구현하세요
        }
        
        // 예시로 성공적으로 삭제된 경우 1을 반환, 실패하면 다른 코드를 반환할 수 있음
        return 1;
    }
	
	@GetMapping("/api/product/category/parent/{categoryNumber}")
	public int parentCategory(@PathVariable int categoryNumber) {
		return  productService.parentCategory(categoryNumber);
	}
	


	@GetMapping("/api/product/sellerProductImage")
	public List<Map<String, Object>> sellerProductImage(@RequestParam("memberId") String memberId) {
	    List<String> productNoList = productService.productNo(memberId);
	    List<Map<String, Object>> productImages = new ArrayList<>();
	    
	    for (String productNo : productNoList) {
	        List<String> images = productService.sellerProductImage(productNo); // productService에 제품 번호에 해당하는 이미지 목록을 가져오는 메서드를 정의해야 함
	        ProductDTO dto = productService.sellerProductPrice(productNo);
	        if (!images.isEmpty()) {
	            String firstImage = images.get(0); // 각 제품의 첫 번째 이미지만 가져옴
	            
	            Map<String, Object> imageMap = new HashMap<>();
	            imageMap.put("productNo", productNo);
	            imageMap.put("image", firstImage);
	            imageMap.put("price", dto.getProductPrice());
	            imageMap.put("title", dto.getProductTitle());
	            
	            productImages.add(imageMap);
	        }
	    }
	    
	    return productImages;
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
	

	
	@GetMapping("/api/product/selectLikeStatus")
	public List<String> selectLikeStatus(@RequestParam("productNo") int productNo) {
		List<String> list = productService.selectLikeStatus(productNo);
		return list;
	}
	
	@PutMapping("/updateProductSaleSatus")
	public Map<String, Object> updateProductSaleSatus(@RequestParam("productNo") int productNo){
		System.out.println(productNo);
		Map<String, Object> map = new HashMap<>();
		try {
			productService.updateProductSaleSatus(productNo);
			map.put("msg", "결제 완료되었습니다");
		} catch (Exception e) {
			map.put("msg", "결제 실패했습니다");
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

	@PostMapping("/api/product/categoryProductImg")
	public List<ProductImageDTO> categoryProductImg(@RequestBody Map<String, Object> productNo){
		System.out.println(productNo);
		List<String> productNos = (List<String>) productNo.get("productNo");
		System.out.println(productNos);
		List<ProductImageDTO> list = productService.categoryProductImg(productNos);
		return list;
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
}