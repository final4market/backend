package com.market.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.market.dto.CategoryDTO;
import com.market.dto.ChatDTO;
import com.market.dto.DeliveryDTO;

import org.springframework.transaction.annotation.Transactional;

import com.market.dto.ProductDTO;
import com.market.dto.ProductImageDTO;
import com.market.dto.ProductLikeDTO;
import com.market.mapper.ProductMapper;

@Service
public class ProductService {
	private ProductMapper mapper;

	public ProductService(ProductMapper mapper) {
		this.mapper = mapper;
	}

	public List<ProductDTO> selectAllProduct() {
		return mapper.selectAllProduct();
	}

	public List<ProductImageDTO> productImage(int productNo) {
		return mapper.productImage(productNo);
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

	public int getProductNo() {
		return mapper.getProductNo();
	}

	public List<CategoryDTO> selectParentCategory(int parNum) {
		return mapper.selectParentCategory(parNum);
	}

	public int insertProductImage(ProductImageDTO productImageDTO) {
		return mapper.insertProductImage(productImageDTO);

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

	public Map<String, ProductImageDTO> selectProductImage(int productNo) {
		return mapper.selectProductImage(productNo);
	}

	public Map<Double, ProductDTO> selectProductPrice(int productNo) {
		return mapper.selectProductPrice(productNo);
	}

	public Map<Double, ProductLikeDTO> selectProductLike(int productNo) {
		return mapper.selectProductLike(productNo);
	}

	public Map<Double, ChatDTO> selectProductChat(int productNo) {
		return mapper.selectProductChat(productNo);
	}
}