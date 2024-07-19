package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.CategoryDTO;
import com.market.dto.DeliveryDTO;
import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;

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


}
