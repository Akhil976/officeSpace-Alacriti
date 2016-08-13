package com.alacriti.officespace.vo;

import java.util.ArrayList;

public class ItemsListVo {
	ArrayList<Item> itemsList =new ArrayList<Item>();

	public ArrayList<Item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(Item item) {
		this.itemsList.add(item);
	}
	
}
