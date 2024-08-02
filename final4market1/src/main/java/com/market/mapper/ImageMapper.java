package com.market.mapper;

import com.market.models.ProductImage;
import com.market.models.MemberProfile;
import com.market.models.Product;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ImageMapper {
	Product findProductById(int productNo);
	ProductImage findProductImageById(int productImageNo);
    void insertProductImage(ProductImage productImage);
    void updateProductImage(ProductImage productImage);
    void deleteProductImage(int productImageNo);
    MemberProfile findMemberProfileById(int memberProfileNo);
    void insertMemberProfile(MemberProfile memberProfile);
    void updateMemberProfile(MemberProfile memberProfile);
    void deleteMemberProfile(int memberProfileNo);
}
