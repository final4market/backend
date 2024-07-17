package com.market.dto;

public class CategoryDTO {
	private int categoryNo;
	private String categoryName;
	
	public CategoryDTO() {
	}
	
	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
	
}
