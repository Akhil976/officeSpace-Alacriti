package com.alacriti.officespace.vo;

public class GraphAnalyticsRequestVo {
	private int itemId;
	private String graphAnalyticsBy;
	private String graphCalValue;

	public GraphAnalyticsRequestVo() {
	}

	public GraphAnalyticsRequestVo( int itemId,
			String graphAnalyticsBy, String graphCalValue) {
		super();
		this.itemId = itemId;
		this.graphAnalyticsBy = graphAnalyticsBy;
		this.graphCalValue = graphCalValue;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getGraphAnalyticsBy() {
		return graphAnalyticsBy;
	}

	public void setGraphAnalyticsBy(String graphAnalyticsBy) {
		this.graphAnalyticsBy = graphAnalyticsBy;
	}

	public String getGraphCalValue() {
		return graphCalValue;
	}

	public void setGraphCalValue(String graphCalValue) {
		this.graphCalValue = graphCalValue;
	}

	@Override
	public String toString() {
		return "GraphAnalyticsRequest [itemId="
				+ itemId + ", graphAnalyticsBy=" + graphAnalyticsBy
				+ ", graphCalValue=" + graphCalValue + "]";
	}

}
