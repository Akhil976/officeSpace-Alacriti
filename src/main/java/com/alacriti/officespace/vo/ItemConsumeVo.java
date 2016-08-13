package com.alacriti.officespace.vo;

public class ItemConsumeVo {

	private int itemId;
	private int categoryId;
	private String date;
	private int consumeAmount;

	public ItemConsumeVo() {
		super();
	}

	public ItemConsumeVo(int itemId, int categoryId, String date,
			int consumeAmount) {
		super();
		this.itemId = itemId;
		this.categoryId = categoryId;
		this.date = date;
		this.consumeAmount = consumeAmount;
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

	public int getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(int consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

	@Override
	public String toString() {
		return "ItemConsumeVo [itemId=" + itemId + ", categoryId=" + categoryId
				+ ", date=" + date + ", consumeAmount=" + consumeAmount + "]";
	}

}
