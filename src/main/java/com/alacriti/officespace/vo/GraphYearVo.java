package com.alacriti.officespace.vo;

import java.util.HashMap;
import java.util.Map;

public class GraphYearVo {
	private Map<String,Integer> yearValues = new HashMap<String,Integer>();

	public int getDayUsage(int day) {
		return yearValues.get(day);
	}

	public void setDayUsage(String day,int usage) {
		yearValues.put(day, usage);
	}
	
	public Map<String, Integer> getGraphYearVoMap(){
		return yearValues;
	}
}
