package com.market.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.market.dto.CategoryDTO;
import com.market.dto.ChatDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.MyPageProductDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ProductLikeDTO;
import com.market.dto.ProductPreviewDTO;
import com.market.dto.SellerPageProductDTO;
import com.market.models.ProductImage;

@Mapper
public interface ProductMapper {
	List<ProductImageDTO> productImage(int productNo);

	ProductDTO productInfo(int productNo);

	DeliveryDTO deliveryInfo(int productNo);

	List<CategoryDTO> categoryInfo(int categoryNo);

	List<ProductDTO> newproductlist();

	List<ProductDTO> hotproductlist();

	int insertProduct(ProductDTO dto);

	int getProductNo();

	List<CategoryDTO> selectAllCategory();

	List<CategoryDTO> selectParentCategory(int parNum);

	int insertProductImage(ProductImageDTO productImageDTO);

	List<ProductImageDTO> selectAllProductImage();

	List<ProductDTO> selectSellerAllProduct();

	List<String> productNo(String memberId);

	List<String> sellerProductImage(String productNo);

	ProductDTO sellerProductPrice(String productNo);

	List<ProductDTO> productsoldoutlist(String memberId);

	List<ProductDTO> ProductPurchaseHistory(String buyerId);

	List<ProductDTO> productSaleslist(String memberId);

	List<ProductImageDTO> selectProductImage(int productNo);

	List<ProductDTO> selectProductPrice(int productNo);

	List<ProductLikeDTO> selectProductLike(int productNo);

	List<ChatDTO> selectProductChat(int productNo);

	int insertProductLike(Map<String, Object> map);

	int deleteProductLike(Map<String, Object> map);

	int productDelete(int productNo);

	List<String> selectLikeStatus(int productNo);

	int updateProductSaleSatus(int productNo);

	int parentCategory(int categoryNumber);

	ProductDTO productUpdate(int productNo);

	int updateProduct(ProductDTO dto);

	List<ProductImage> updateProductImages(int productNo);

	int updateProductImage(ProductImageDTO productImageDTO);

	List<ProductDTO> categoryProductInfo(int categoryNo);

	List<ProductImage> updateloadProductImages(int productNo);

	int deleteProductImages(int productNo, String imageNo);

	List<ProductDTO> searchResult(Map<String, Object> params);

	Set<Integer> getExistingImageNumbers(@Param("productNo") int productNo);

	// 이미지를 삽입하는 메소드
	void insertProductImage(@Param("productImageDTO") ProductImageDTO productImageDTO, @Param("imageNo") int imageNo);

	List<ProductImageDTO> categoryProductImg(List<String> productNos);

	int insertTransaction(Map<String, Object> map);

	int productStatusUpdate(Map<String, Object> map);

	int ProductStatusDelete(int productNo);

	ProductPreviewDTO getProductPreview(@Param("productNo") int productNo);

	List<MyPageProductDTO> myPageProduct(String memberId);

	List<MyPageProductDTO> myPageInterestProduct(String memberId);

	List<SellerPageProductDTO> sellerPageProduct(String sellerId);
}