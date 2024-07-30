package com.market.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.market.dto.CategoryDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.MyPageProductDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.mapper.ProductMapper;

@Service
public class ProductService {

	private ProductMapper mapper;

	public ProductService(ProductMapper mapper) {
		this.mapper = mapper;
	}


	public List<ProductDTO> newproductlist() {
		return mapper.newproductlist();
	}

	public List<ProductDTO> hotproductlist() {
		return mapper.hotproductlist();
	}
	

	public ProductDTO productInfo(int productNo) {
		return mapper.productInfo(productNo);
	}

	public DeliveryDTO deliveryInfo(int productNo) {
		return mapper.deliveryInfo(productNo);
	}

	public List<CategoryDTO> categoryInfo(int categoryNo) {
		return mapper.categoryInfo(categoryNo);
	}

	public List<CategoryDTO> selectAllCategory() {
		return mapper.selectAllCategory();
	}
  

  
	public int insertProduct(ProductDTO dto) {
		return mapper.insertProduct(dto);
	}

	public int updateProduct(ProductDTO dto) {
		return mapper.updateProduct(dto);
		
	}
	public int getProductNo() {
		return mapper.getProductNo();
	}

	public List<CategoryDTO> selectParentCategory(int parNum) {
		return mapper.selectParentCategory(parNum);
	}

	public int insertProductImage(ProductImageDTO productImageDTO) {
		return mapper.insertProductImage(productImageDTO);
	}
	
	public int updateProductImage(ProductImageDTO productImageDTO) {
		return mapper.updateProductImage(productImageDTO);
		
	}

	public List<ProductImageDTO> 
    ProductImage() {
		return mapper.selectAllProductImage();
	}
  
    public List<ProductImageDTO> selectAllProductImage() {
        return mapper.selectAllProductImage();
    }

	public List<ProductDTO> selectSellerAllProduct() {
		return mapper.selectSellerAllProduct();
	}

	public List<String> productNo(String memberId) {
		return mapper.productNo(memberId);
	}

	public List<String> sellerProductImage(String productNo) {
		return mapper.sellerProductImage(productNo);
	}

	public int sellerProductPrice(String productNo) {
		return mapper.sellerProductPrice(productNo);
	}


	public List<ProductDTO> ProductPurchaseHistory(String buyerId) {
		return mapper.ProductPurchaseHistory(buyerId);
	}

	public List<ProductDTO> productsoldoutlist(String memberId) {
		return mapper.productsoldoutlist(memberId);
	}

	public List<ProductDTO> productSaleslist(String memberId) {
		return mapper.productSaleslist(memberId);
	}


	public ProductImageDTO selectFile(int productNo, int productImageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productNo", productNo);
		map.put("productImageNo", productImageNo);
		return mapper.selectProductdFile(map);
	}

	public List<ProductImageDTO> selectProductImage(int productNo) {
		return mapper.selectProductImage(productNo);}

	public MyPageProductDTO myPageProduct(int productNo) {
		return mapper.myPageProduct(productNo);

	}

	public MyPageProductDTO myPageInterest(int productNo) {
		return mapper.myPageInterest(productNo);
	}

	public int insertProductLike(String memberId, int productNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("productNo", productNo);
		return mapper.insertProductLike(map);
	}

	public int deleteProductLike(String memberId, int productNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("productNo", productNo);
		return mapper.deleteProductLike(map);
	}
	
	public List<String> selectLikeStatus(int productNo) {
		return mapper.selectLikeStatus(productNo);
	}

	public int productDelete(int productNo) {
		return mapper.productDelete(productNo) ;
	}



	public int updateProductSaleSatus(int productNo) {
		return mapper.updateProductSaleSatus(productNo);
	}



	public int parentCategory(int categoryNumber) {
		return mapper. parentCategory(categoryNumber);
	}

	
	public ProductDTO productUpdate(int productNo) {
		return mapper.productUpdate(productNo);
	}

    public List<ProductImageDTO> productImage(int productNo) {
        return mapper.productImage(productNo);
    }

	 // 이미지 키 저장을 위한 새로운 메서드
    public void saveProductImages(int productNo, List<String> imageKeys) {
        for (int i = 0; i < imageKeys.size(); i++) {
            String imageKey = imageKeys.get(i);
            if (imageKey != null && !imageKey.isEmpty()) {  // null 값 필터링
                ProductImageDTO productImageDTO = new ProductImageDTO(productNo, i, imageKey);
                insertProductImage(productImageDTO);
            }
        }
    }


    public List<ProductDTO> searchResult(String minPrice, String maxPrice, String includeSoldOut, String sortOrder, String searchQuery) {
        Map<String, Object> params = new HashMap<>();
        params.put("minPrice", minPrice);
        params.put("maxPrice", maxPrice);
        params.put("includeSoldOut", includeSoldOut);
        params.put("sortOrder", sortOrder);
        params.put("searchQuery", searchQuery);

        return mapper.searchResult(params);
    }


	

	
}


