package com.alacriti.officespace.vo;

public class UpdateCapacityVo {
	private int itemId;
	private int categoryId;
	private int newCapacity;
	
	public UpdateCapacityVo() {
	}
	public UpdateCapacityVo(int itemId, int categoryId, int newCapacity) {
		super();
		this.itemId = itemId;
		this.categoryId = categoryId;
		this.newCapacity = newCapacity;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getNewCapacity() {
		return newCapacity;
	}
	public void setNewCapacity(int newCapacity) {
		this.newCapacity = newCapacity;
	}
}
