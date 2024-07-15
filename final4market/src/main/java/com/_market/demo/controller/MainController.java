package com._market.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com._market.demo.dto.CategoryDTO;
import com._market.demo.dto.ProductDTO;
import com._market.demo.service.ProductService;


import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class MainController {
  private ProductService service;
  
  public MainController(ProductService service) {
	  this.service = service;
  }
	@GetMapping("/Product/list")
	public List<ProductDTO> selectAllProduct() {
	return service.selectAllProduct();
	}
	
	@GetMapping("/Category/list")
	public List<CategoryDTO> selectAllCategory() {
		return service.selectAllCategory();
	}
	@GetMapping("/Category/list/{parNum}")
	public List<CategoryDTO> selectParentCategory(@PathVariable int parNum) {
		return service.selectParentCategory(parNum);
	}
	
	@PostMapping("product/insert")
	public Map<String, Object> insertProduct(@RequestBody Map<String, String> params) {
	    ProductDTO dto = new ProductDTO();
	    dto.setProductTitle(params.get("productTitle"));
	    dto.setProductPrice(Integer.parseInt(params.get("productPrice")));
	    dto.setCategoryNo(Integer.parseInt(params.get("categoryNo")));
	    dto.setProductContent(params.get("productContent"));
	    dto.setProductStatus(params.get("productStatus"));
	    dto.setDeliveryNo(Integer.parseInt(params.get("deliveryNo")));
	    dto.setTradeArea(params.get("tradeArea"));
	    
	    Map<String, Object> map = new HashMap<>();
	    try {
	        // ProductService에서 getProductNo()를 호출하여 시퀀스 값을 가져온 후, DTO에 설정
	        int productNo = service.getProductNo();
	        dto.setProductNo(productNo);
	        
	        // ProductService에서 insertProduct(dto)를 호출하여 데이터베이스에 삽입
	        service.insertProduct(dto);
	        
	        map.put("msg", "상품 등록 성공");
	        map.put("result", true);
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put("msg", "상품 등록 실패");
	        map.put("result", false);
	    }
	    return map;
	}
	
  
}
