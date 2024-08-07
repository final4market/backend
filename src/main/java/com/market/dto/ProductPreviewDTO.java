package com.market.dto;

import org.apache.ibatis.type.Alias;

@Alias("productPreview")
public class ProductPreviewDTO {
	private String productTitle;
	private String productContent;
	private String productSale;
	private String sellerId;
	private String productImagePath;
    
    public ProductPreviewDTO() {   
    	
    }

	public ProductPreviewDTO(String productTitle, String productContent, String productSale, String sellerId,
			String productImagePath) {
		this.productTitle = productTitle;
		this.productContent = productContent;
		this.productSale = productSale;
		this.sellerId = sellerId;
		this.productImagePath = productImagePath;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public String getProductSale() {
		return productSale;
	}

	public void setProductSale(String productSale) {
		this.productSale = productSale;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	@Override
	public String toString() {
		return "ProductPreviewDTO [productTitle=" + productTitle + ", productContent=" + productContent
				+ ", productSale=" + productSale + ", sellerId=" + sellerId + ", productImagePath=" + productImagePath
				+ "]";
	}    
}


