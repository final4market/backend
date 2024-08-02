package com.market.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("productMainView")
public class ProductMainViewDTO {
	private int productNo;
	private int productPrice;
	private int productCount;
	private Date productDate;
    private String productStatus;
    private String productSale;
	private String productTitle;
    private int categoryNo;
    private int productImageNo;
	private String productImagePath;
	private int productLike;
	public ProductMainViewDTO() {
		
	}
	
	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductSale() {
		return productSale;
	}

	public void setProductSale(String productSale) {
		this.productSale = productSale;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getProductImageNo() {
		return productImageNo;
	}

	public void setProductImageNo(int productImageNo) {
		this.productImageNo = productImageNo;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public int getProductLike() {
		return productLike;
	}

	public void setProductLike(int productLike) {
		this.productLike = productLike;
	}

	public ProductMainViewDTO(int productNo, int productPrice, int productCount, Date productDate, String productStatus,
			String productSale, String productTitle, int categoryNo, int productImageNo, String productImagePath,
			int productLike) {
		super();
		this.productNo = productNo;
		this.productPrice = productPrice;
		this.productCount = productCount;
		this.productDate = productDate;
		this.productStatus = productStatus;
		this.productSale = productSale;
		this.productTitle = productTitle;
		this.categoryNo = categoryNo;
		this.productImageNo = productImageNo;
		this.productImagePath = productImagePath;
		this.productLike = productLike;
	}
	
}