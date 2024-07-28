package com.market.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.CategoryDTO;
import com.market.dto.ChatDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ProductLikeDTO;

@Mapper
public interface ProductMapper {
	List<ProductImageDTO> productImage(int productNo);

	ProductDTO productInfo(int productNo);

	DeliveryDTO deliveryInfo(int productNo);

	List<CategoryDTO> categoryInfo(int categoryNo);

	List<ProductDTO> selectAllProduct();

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

	List<ProductImageDTO> selectProductImage(int productNo);

	List<ProductDTO> selectProductPrice(int productNo);

	List<ProductLikeDTO> selectProductLike(int productNo);

	List<ChatDTO> selectProductChat(int productNo);

	int insertProductLike(Map<String, Object> map);

	int deleteProductLike(Map<String, Object> map);

	List<String> selectLikeStatus(int productNo);

	int updateProductSaleSatus(int productNo);

	List<ProductDTO> categoryProductInfo(int categoryNo);

	List<ProductImageDTO> categoryProductImg(List<String> productNos);

}

