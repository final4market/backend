package com.market.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.ProductImageDAO;
import com.market.dto.CategoryDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.MyPageProductDTO;
import com.market.dto.MyPageReceivedReviewDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ProductPreviewDTO;
import com.market.dto.SellerPageProductDTO;
import com.market.dto.SellerPageReceivedReviewDTO;
import com.market.mapper.ProductMapper;
import com.market.models.ProductImage;
import com.market.dto.SellerPageProductDTO;
import com.market.dto.SellerPageReceivedReviewDTO;

@Service
public class ProductService {
    
    private final ProductImageDAO productImageDAO;
    private final ProductMapper mapper;

    @Autowired
    public ProductService(ProductImageDAO productImageDAO, ProductMapper mapper) {
        this.productImageDAO = productImageDAO;
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
	

	public List<ProductImageDTO> ProductImage() {
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


	public ProductDTO sellerProductPrice(String productNo) {
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


	public List<ProductImageDTO> selectProductImage(int productNo) {
		return mapper.selectProductImage(productNo);}

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

	public List<ProductDTO> categoryProductInfo(int categoryNo) {
		return mapper.categoryProductInfo(categoryNo);
	}


	public List<ProductImageDTO> categoryProductImg(List<String> productNos) {
		return mapper.categoryProductImg(productNos);
	}


	public List<MyPageProductDTO> myPageProduct(String memberId) {
		return mapper.myPageProduct(memberId);
	}

	public List<MyPageProductDTO> myPageInterestProduct(String memberId) {
		return mapper.myPageInterestProduct(memberId);
	}
	
	public int insertTransaction(int productNo, String memberId) {
		Map<String, Object> map = new HashMap<>();
		map.put("productNo", productNo);
		map.put("memberId", memberId);
		return mapper.insertTransaction(map);
	}

    public List<ProductDTO> searchResult(String minPrice, String maxPrice, String includeSoldOut, String sortOrder, String searchQuery,
    		String categoryNo, String parentCategoryNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("minPrice", minPrice);
        params.put("maxPrice", maxPrice);
        params.put("includeSoldOut", includeSoldOut);
        params.put("sortOrder", sortOrder);
        params.put("searchQuery", searchQuery);
        params.put("categoryNo", categoryNo);
        params.put("parentCategoryNo", parentCategoryNo);
        
        return mapper.searchResult(params);
        
    }


    public void updateProductImages(int productNo, List<String> imageKeys) {
        // 1. 이미 존재하는 이미지 번호를 데이터베이스에서 가져옵니다.
    	for (int j = 0; j < imageKeys.size(); j++) {
        Set<Integer> existingImageNumbers = fetchExistingImageNumbers(productNo);
    
        // 2. 사용할 수 있는 이미지 번호를 찾습니다.
        Set<Integer> availableImageNumbers = new HashSet<>();
        
        
        for (int i = 0; i < 3; i++) {
            if (!existingImageNumbers.contains(i)) {
                availableImageNumbers.add(i);
               System.out.println("사용가능한 이미지 번호"+availableImageNumbers);
            }
        }
        System.out.println("리스트 크기: " + imageKeys.size());
        // 3. 유효한 이미지 키에 대해 이미지를 삽입합니다.
       
        for (int i = 0; i < 3; i++) {
            if (availableImageNumbers.contains(i)) {
            	 String imageKey = imageKeys.get(j);
                 System.out.println("가져오는"+imageKey);
                 if (imageKey != null && !imageKey.isEmpty()) {
                     ProductImageDTO productImageDTO = new ProductImageDTO(productNo, imageKey);
                     updateProductImage(productImageDTO, i);  // 인덱스를 전달합니다.
                     break;
            }
               
                }}
           
        }
    }
    // 기존 이미지 번호를 가져오는 메소드
    private Set<Integer> fetchExistingImageNumbers(int productNo) {
        return productImageDAO.getExistingImageNumbers(productNo);
    }

    // 이미지를 삽입하는 메소드
    private void updateProductImage(ProductImageDTO productImageDTO, int productImageNo) {
        productImageDAO.updateProductImage(productImageDTO, productImageNo);
    }


	public List<ProductImage> updateloadProductImages(int productNo) {
		return mapper.updateloadProductImages(productNo);
	}


	public void deleteProductImages(int productNo, String imageNo) {
		mapper.deleteProductImages(productNo,imageNo);
		
	}

	public int productStatusUpdate(String status, int productNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("productNo", productNo);
        return mapper.productStatusUpdate(map);

    }


    public int ProductStatusDelete(int productNo) {
        return mapper.ProductStatusDelete(productNo);
    }
    
    // 상품 미리보기 가져오기
    public ProductPreviewDTO getProductPreview(int productNo) {
        return mapper.getProductPreview(productNo);
    }
  
	public List<SellerPageProductDTO> sellerPageProduct(String sellerId) {
		return mapper.sellerPageProduct(sellerId);
	}
}