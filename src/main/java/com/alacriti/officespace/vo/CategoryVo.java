package com.alacriti.officespace.vo;

public class CategoryVo {
	private int categoryId;
	private String categoryName;
	public CategoryVo() {
		super();
	}
	public CategoryVo(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "CategoryVo [categoryId=" + categoryId + ", categoryName="
				+ categoryName + "]";
	}
	
	
	
}
