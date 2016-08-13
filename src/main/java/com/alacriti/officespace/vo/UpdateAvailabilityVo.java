package com.alacriti.officespace.vo;

public class UpdateAvailabilityVo {
	private int categoryId;
	private int itemId;
	private int updateAmount;
	private String updateAction;
	
	public UpdateAvailabilityVo() {
	}
	public UpdateAvailabilityVo(int categoryId, int itemId, int updateAmount,
			String updateAction) {
		super();
		this.itemId = itemId;
		this.categoryId = categoryId;
		this.updateAmount = updateAmount;
		this.updateAction = updateAction;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getUpdateAmount() {
		return updateAmount;
	}
	public void setUpdateAmount(int updateAmount) {
		this.updateAmount = updateAmount;
	}
	public String getUpdateAction() {
		return updateAction;
	}
	public void setUpdateAction(String updateAction) {
		this.updateAction = updateAction;
	}
	@Override
	public String toString() {
		return "UpdateAvailabilityVo [categoryId=" + categoryId + ", itemId="
				+ itemId + ", updateAmount=" + updateAmount + ", updateAction="
				+ updateAction + "]";
	}
	
}
