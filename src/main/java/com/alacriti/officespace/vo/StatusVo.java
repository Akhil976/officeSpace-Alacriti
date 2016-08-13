package com.alacriti.officespace.vo;

public class StatusVo {
	private int availableItems;
	private int currentCapacity;
	private int fillPercentage;

	public StatusVo() {
	}

	public StatusVo(int availableItems, int currentCapacity, int fillPercentage) {
		super();
		this.availableItems = availableItems;
		this.currentCapacity = currentCapacity;
		this.fillPercentage = fillPercentage;
	}

	public int getAvailableItems() {
		return availableItems;
	}

	public void setAvailableItems(int availableItems) {
		this.availableItems = availableItems;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public int getFillPercentage() {
		return fillPercentage;
	}

	public void setFillPercentage(int fillPercentage) {
		this.fillPercentage = fillPercentage;
	}

	@Override
	public String toString() {
		return "StatusVo [availableItems=" + availableItems
				+ ", currentCapacity=" + currentCapacity + ", fillPercentage="
				+ fillPercentage + "]";
	}

}
