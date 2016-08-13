package com.alacriti.officespace.vo;

public class AddItemVo {
	
	private int categoryId;
	private String newItem;
	private int maxCapacity;
	
	public AddItemVo() {
	}
	public AddItemVo(int categoryId, String newItem, int maxCapacity) {
		super();
		this.categoryId = categoryId;
		this.newItem = newItem;
		this.maxCapacity = maxCapacity;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getNewItem() {
		return newItem;
	}
	public void setNewItem(String newItem) {
		this.newItem = newItem;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
}
