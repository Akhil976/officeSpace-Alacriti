package com.alacriti.officespace.vo;

import java.util.ArrayList;

public class Category {

	private int categoryId;
	private String categoryName;
	ArrayList<Item> items = new ArrayList<Item>();

	public Category() {
		super();
	}

	public Category(int categoryId, String categoryName, ArrayList<Item> items) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.items = items;
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

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void setItem(Item item){
		items.add(item);
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", items=" + items + "]";
	}

}
