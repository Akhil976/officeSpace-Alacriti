package com.alacriti.officespace.vo;

import java.util.ArrayList;

public class ItemDetailsAdmin {
	private int availableItems;
	private int inventoryCapacity;
	private int fillPercentage;
	private int alalyticsDay;
	private int alalyticsWeek;
	private int alalyticsMonth;
	private int alalyticsYear;
	private ArrayList<CategoryVo> categoryList;

	public ItemDetailsAdmin() {
	}

	public ItemDetailsAdmin(int availableItems, int inventoryCapacity,
			int fillPercentage, int alalyticsDay, int alalyticsWeek,
			int alalyticsMonth, int alalyticsYear, ArrayList<CategoryVo> categoryList) {
		super();
		this.availableItems = availableItems;
		this.inventoryCapacity = inventoryCapacity;
		this.fillPercentage = fillPercentage;
		this.alalyticsDay = alalyticsDay;
		this.alalyticsWeek = alalyticsWeek;
		this.alalyticsMonth = alalyticsMonth;
		this.alalyticsYear = alalyticsYear;
		this.categoryList = categoryList;
	}

	public int getAvailableItems() {
		return availableItems;
	}

	public void setAvailableItems(int availableItems) {
		this.availableItems = availableItems;
	}

	public int getInventoryCapacity() {
		return inventoryCapacity;
	}

	public void setInventoryCapacity(int inventoryCapacity) {
		this.inventoryCapacity = inventoryCapacity;
	}

	public int getFillPercentage() {
		return fillPercentage;
	}

	public void setFillPercentage(int fillPercentage) {
		this.fillPercentage = fillPercentage;
	}

	public int getAlalyticsDay() {
		return alalyticsDay;
	}

	public void setAlalyticsDay(int alalyticsDay) {
		this.alalyticsDay = alalyticsDay;
	}

	public int getAlalyticsWeek() {
		return alalyticsWeek;
	}

	public void setAlalyticsWeek(int alalyticsWeek) {
		this.alalyticsWeek = alalyticsWeek;
	}

	public int getAlalyticsMonth() {
		return alalyticsMonth;
	}

	public void setAlalyticsMonth(int alalyticsMonth) {
		this.alalyticsMonth = alalyticsMonth;
	}

	public int getAlalyticsYear() {
		return alalyticsYear;
	}

	public void setAlalyticsYear(int alalyticsYear) {
		this.alalyticsYear = alalyticsYear;
	}

	public ArrayList<CategoryVo> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<CategoryVo> categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public String toString() {
		return "ItemDetailsAdmin [availableItems=" + availableItems
				+ ", inventoryCapacity=" + inventoryCapacity
				+ ", fillPercentage=" + fillPercentage + ", alalyticsDay="
				+ alalyticsDay + ", alalyticsWeek=" + alalyticsWeek
				+ ", alalyticsMonth=" + alalyticsMonth + ", alalyticsYear="
				+ alalyticsYear + ", categoryList=" + categoryList + "]";
	}
	

}
