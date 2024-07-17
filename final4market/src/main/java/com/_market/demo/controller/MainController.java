package com._market.demo.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com._market.demo.dto.CategoryDTO;
import com._market.demo.dto.ProductDTO;
import com._market.demo.dto.ProductImageDTO;
import com._market.demo.service.ProductService;



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
	

	@PostMapping("/product/insert")
	public Map<String, Object> insertProduct2(@RequestParam Map<String, String> params,
	                                          @RequestParam("file") MultipartFile[] file) throws NumberFormatException {
	    Map<String, Object> map = new HashMap<>();
	    try {
	        ProductDTO dto = new ProductDTO();
	        dto.setProductTitle(params.get("productTitle"));
	        dto.setProductPrice(Integer.parseInt(params.get("productPrice")));
	        dto.setCategoryNo(Integer.parseInt( params.get("categoryNo")));
	        dto.setProductContent(params.get("productContent"));
	        dto.setProductStatus(params.get("productStatus"));
	        dto.setDeliveryNo(Integer.parseInt(params.get("deliveryNo")));
	        dto.setTradeArea(params.get("tradeArea"));
	     
	        
	        int productNo = service.getProductNo();
	        dto.setProductNo(productNo);
	        
	        service.insertProduct(dto);
	        
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
	            service.insertProductImage(productImageDTO);
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
	}