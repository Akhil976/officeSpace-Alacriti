package com.alacriti.officespace.vo;

public class GraphCategoryVo {

	private String categoryName;
	private int categoryId;
	private int categoryAvailableItems;

	public GraphCategoryVo() {
		super();
	}

	public GraphCategoryVo(String categoryName, int categoryId,
			int categoryAvailableItems) {
		super();
		this.categoryName = categoryName;
		this.categoryId = categoryId;
		this.categoryAvailableItems = categoryAvailableItems;
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

	public int getCategoryAvailableItems() {
		return categoryAvailableItems;
	}

	public void setCategoryAvailableItems(int categoryAvailableItems) {
		this.categoryAvailableItems = categoryAvailableItems;
	}

	@Override
	public String toString() {
		return "GraphCategoryVo [categoryName=" + categoryName
				+ ", categoryAvailableItems=" + categoryAvailableItems + "]";
	}

}
