package com.alacriti.officespace.vo;

public class AnalyticsTotal {
	private int analyticsDay;
	private int analyticsWeek;
	private int analyticsMonth;
	private int analyticsYear;

	public AnalyticsTotal() {
	}
	public AnalyticsTotal(int analyticsDay, int analyticsWeek, int analyticsMonth,
			int analyticsYear) {
		super();
		this.analyticsDay = analyticsDay;
		this.analyticsWeek = analyticsWeek;
		this.analyticsMonth = analyticsMonth;
		this.analyticsYear = analyticsYear;
	}
	public int getAnalyticsDay() {
		return analyticsDay;
	}
	public void setAnalyticsDay(int analyticsDay) {
		this.analyticsDay = analyticsDay;
	}
	public int getAnalyticsWeek() {
		return analyticsWeek;
	}
	public void setAnalyticsWeek(int analyticsWeek) {
		this.analyticsWeek = analyticsWeek;
	}
	public int getAnalyticsMonth() {
		return analyticsMonth;
	}
	public void setAnalyticsMonth(int analyticsMonth) {
		this.analyticsMonth = analyticsMonth;
	}
	public int getAnalyticsYear() {
		return analyticsYear;
	}
	public void setAnalyticsYear(int analyticsYear) {
		this.analyticsYear = analyticsYear;
	}
	@Override
	public String toString() {
		return "AnalyticsTotal [analyticsDay=" + analyticsDay
				+ ", analyticsWeek=" + analyticsWeek + ", analyticsMonth="
				+ analyticsMonth + ", analyticsYear=" + analyticsYear + "]";
	}
	
}
