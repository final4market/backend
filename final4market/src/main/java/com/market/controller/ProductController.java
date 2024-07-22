package com.market.controller;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.market.dto.CategoryDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*" )
public class ProductController {
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/productImage")
	public List<ProductImageDTO> productImage(int productNo) {
		List<ProductImageDTO> list = productService.productImage(productNo);
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/productInfo")
	public ProductDTO productInfo(int productNo) {
		ProductDTO dto = productService.productInfo(productNo);
		return dto; 
	}
	
	@GetMapping("/deliveryInfo")
	public DeliveryDTO deliveryInfo(int productNo) {
		DeliveryDTO dto = productService.deliveryInfo(productNo);
		System.out.println(dto);
		return dto; 
	}
	
	@GetMapping("/categoryInfo")
	public List<CategoryDTO> categoryInfo(int categoryNo) {
		List<CategoryDTO> list = productService.categoryInfo(categoryNo);
		return list; 
	}
	
	@GetMapping("/product/list")
	public List<ProductDTO> selectAllProduct() {
	return productService.selectAllProduct();
	}
	
	@GetMapping("/category/list")
	public List<CategoryDTO> selectAllCategory() {
		return productService.selectAllCategory();
	}
	@GetMapping("/category/list/{parNum}")
	public List<CategoryDTO> selectParentCategory(@PathVariable int parNum) {
		return productService.selectParentCategory(parNum);
	}
	

	@PostMapping("/product/insert")
	public Map<String, Object> insertProduct2(@RequestParam Map<String, String> params,
	                                          @RequestParam("file") MultipartFile[] file) throws NumberFormatException {
	    Map<String, Object> map = new HashMap<>();
	    try {
	        ProductDTO dto = new ProductDTO();
	        dto.setProductTitle(params.get("productTitle"));
	        dto.setProductPrice(Integer.parseInt(params.get("productPrice")));
	        dto.setCategoryNo(Integer.parseInt(params.get("categoryNo")));
	        dto.setProductContent(params.get("productContent"));
	        dto.setProductStatus(params.get("productStatus"));
	        dto.setDeliveryNo(Integer.parseInt(params.get("deliveryNo")));
	        dto.setTradeArea(params.get("tradeArea"));
	        
	        // deliveryCharge 값이 null일 경우를 처리
	        String deliveryChargeStr = params.get("deliveryCharge");
	        dto.setDeliveryCharge(deliveryChargeStr != null && !deliveryChargeStr.isEmpty() ? Integer.parseInt(deliveryChargeStr) : 0);
	        
	        int productNo = productService.getProductNo();
	        dto.setProductNo(productNo);
	        
	        productService.insertProduct(dto);
	        
	        File root = new File("c:\\fileupload");
	        if (!root.exists()) {
	            root.mkdirs();
	        }
	        
	        for (int i = 0; i < file.length; i++) {
	            if (file[i].getSize() == 0) {
	                continue;
	            }
	            File f = new File(root, file[i].getOriginalFilename());
	            file[i].transferTo(f);
	            ProductImageDTO productImageDTO = new ProductImageDTO(f, productNo);
	            productService.insertProductImage(productImageDTO);
	        }
	        
	        map.put("msg", "상품 등록 성공");
	        map.put("result", true);
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	        map.put("msg", "입력 값 오류: " + e.getMessage());
	        map.put("result", false);
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put("msg", "상품 등록 실패");
	        map.put("result", false);
	    }
	    return map;
	}

	@GetMapping("/sellerProductImage")
	public List<Map<String, Object>> sellerProductImage(String memberId) {
	    List<String> productNoList = productService.productNo(memberId);
	    List<Map<String, Object>> productImages = new ArrayList<>();
	    
	    for (String productNo : productNoList) {
	        List<String> images = productService.sellerProductImage(productNo); // productService에 제품 번호에 해당하는 이미지 목록을 가져오는 메서드를 정의해야 함
	        int price = productService.sellerProductPrice(productNo);
	        if (!images.isEmpty()) {
	            String firstImage = images.get(0); // 각 제품의 첫 번째 이미지만 가져옴
	            
	            Map<String, Object> imageMap = new HashMap<>();
	            imageMap.put("productNo", productNo);
	            imageMap.put("image", firstImage);
	            imageMap.put("price", price);
	            
	            productImages.add(imageMap);
	        }
	    }
	    
	    return productImages;
	}
	
	@GetMapping("/insertProductLike")
	public Map<String, Object> productLike(String memberId, int productNo) {
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
	
	
}
