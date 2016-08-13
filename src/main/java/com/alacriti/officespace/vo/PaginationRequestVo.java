package com.alacriti.officespace.vo;

public class PaginationRequestVo {
	
	private int itemId;
	private int categoryId;
	private String date;

	public PaginationRequestVo() {
		super();
	}

	public PaginationRequestVo(int itemId, int categoryId, String date) {
		super();
		this.itemId = itemId;
		this.categoryId = categoryId;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PaginationRequestVo [itemId=" + itemId + ", categoryId="
				+ categoryId + ", date=" + date + "]";
	}

}
