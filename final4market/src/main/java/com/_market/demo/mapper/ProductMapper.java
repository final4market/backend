package com._market.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com._market.demo.dto.CategoryDTO;
import com._market.demo.dto.ProductDTO;
import com._market.demo.dto.ProductImageDTO;

@Mapper
public interface ProductMapper {

	List<ProductDTO> selectAllProduct();

	int insertProduct(ProductDTO dto);

	int getProductNo();

	List<CategoryDTO> selectAllCategory();

	List<CategoryDTO> selectParentCategory(int parNum);

	int insertProductImage(ProductImageDTO productImageDTO);





}
