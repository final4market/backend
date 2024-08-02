package com.market.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.market.dto.ProductImageDTO;

@Mapper
public interface ProductImageDAO {

    // 기존 이미지 번호를 가져오는 메소드
    Set<Integer> getExistingImageNumbers(@Param("productNo") int productNo);

    // 이미지를 삽입하는 메소드
    void updateProductImage(@Param("productImageDTO") ProductImageDTO productImageDTO, @Param("productImageNo") int productImageNo);
}
