package com.market.dto;

import org.apache.ibatis.type.Alias;

@Alias("Category")
public class CategoryDTO {
	    private int categoryNo;
	    private int parentCategoryNo;
	    private String categoryName;

	    public CategoryDTO() {
	    }

		public CategoryDTO(int categoryNo, int parentCategoryNo, String categoryName) {
			super();
			this.categoryNo = categoryNo;
			this.parentCategoryNo = parentCategoryNo;
			this.categoryName = categoryName;
		}

		public int getCategoryNo() {
			return categoryNo;
		}

		public void setCategoryNo(int categoryNo) {
			this.categoryNo = categoryNo;
		}

		public int getParentCategoryNo() {
			return parentCategoryNo;
		}

		public void setParentCategoryNo(int parentCategoryNo) {
			this.parentCategoryNo = parentCategoryNo;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		@Override
		public String toString() {
			return "CategoryDTO [categoryNo=" + categoryNo + ", parentCategoryNo=" + parentCategoryNo
					+ ", categoryName=" + categoryName + "]";
		}

}
