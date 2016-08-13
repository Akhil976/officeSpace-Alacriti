package com.alacriti.officespace.vo;

public class GraphObjectsVo {
	
	private GraphYearVo graphYearVo;
	private GraphMonthVo graphMonthVo;
	private GraphWeekVo graphWeekVo;

	public GraphObjectsVo() {
	}

	public GraphObjectsVo(GraphYearVo graphYearVo, GraphMonthVo graphMonthVo,
			GraphWeekVo graphWeekVo) {
		super();
		this.graphYearVo = graphYearVo;
		this.graphMonthVo = graphMonthVo;
		this.graphWeekVo = graphWeekVo;
	}

	public GraphYearVo getGraphYearVo() {
		return graphYearVo;
	}

	public void setGraphYearVo(GraphYearVo graphYearVo) {
		this.graphYearVo = graphYearVo;
	}

	public GraphMonthVo getGraphMonthVo() {
		return graphMonthVo;
	}

	public void setGraphMonthVo(GraphMonthVo graphMonthVo) {
		this.graphMonthVo = graphMonthVo;
	}

	public GraphWeekVo getGraphWeekVo() {
		return graphWeekVo;
	}

	public void setGraphWeekVo(GraphWeekVo graphWeekVo) {
		this.graphWeekVo = graphWeekVo;
	}

	@Override
	public String toString() {
		return "GraphObjectsVo [graphYearVo=" + graphYearVo + ", graphMonthVo="
				+ graphMonthVo + ", graphWeekVo=" + graphWeekVo + "]";
	}

}
