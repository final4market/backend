package com.market.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.CategoryDTO;
import com.market.dto.ChatDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.MyPageProductDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ProductLikeDTO;
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

	int sellerProductPrice(String productNo);


	List<ProductDTO> productsoldoutlist(String memberId);

	List<ProductDTO> ProductPurchaseHistory(String buyerId);

	List<ProductDTO> productSaleslist(String memberId);

	ProductImageDTO selectProductdFile(Map<String, Object> map);

	List<ProductImageDTO> selectProductImage(int productNo);

	List<ProductDTO> selectProductPrice(int productNo);

	List<ProductLikeDTO> selectProductLike(int productNo);

	List<ChatDTO> selectProductChat(int productNo);

	MyPageProductDTO myPageProduct(int productNo);


	int insertProductLike(Map<String, Object> map);

	int deleteProductLike(Map<String, Object> map);


	int productDelete(int productNo);


	MyPageProductDTO myPageInterest(int productNo);
	
	List<String> selectLikeStatus(int productNo);


	int updateProductSaleSatus(int productNo);



	int parentCategory(int categoryNumber);

	ProductDTO productUpdate(int productNo);

	 int updateProduct(ProductDTO dto);

	

	List<ProductImage> updateProductImages(int productNo);

	int updateProductImage(ProductImageDTO productImageDTO);

	List<ProductImage> updateloadProductImages(int productNo);

	void deleteProductImages(int productNo);

	

	List<ProductDTO> searchResult(Map<String, Object> params);






}