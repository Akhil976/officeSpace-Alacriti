package com.alacriti.officespace.vo;

import java.util.HashMap;
import java.util.Map;

public class GraphMonthVo {
	private Map<String,Integer> monthValues = new HashMap<String,Integer>();

	public int getDayUsage(int day) {
		return monthValues.get(day);
	}

	public void setDayUsage(String day,int usage) {
		monthValues.put(day, usage);
	}
	
	public Map<String, Integer> getGraphMonthVoMap(){
		return monthValues;
	}
}
