package com.alacriti.officespace.vo;

public class AnalyticsRequestVo {

	private int itemId;
	private String analyticsBy;
	private String calenderValue;

	public AnalyticsRequestVo() {
	}

	public AnalyticsRequestVo( int itemId, String analyticsBy,
			String calenderValue) {
		super();
		this.itemId = itemId;
		this.analyticsBy = analyticsBy;
		this.calenderValue = calenderValue;
	}


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getAnalyticsBy() {
		return analyticsBy;
	}

	public void setAnalyticsBy(String analyticsBy) {
		this.analyticsBy = analyticsBy;
	}

	public String getCalenderValue() {
		return calenderValue;
	}

	public void setCalenderValue(String calenderValue) {
		this.calenderValue = calenderValue;
	}

}
