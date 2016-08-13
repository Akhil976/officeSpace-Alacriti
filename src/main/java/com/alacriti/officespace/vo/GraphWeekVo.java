package com.alacriti.officespace.vo;

import java.util.HashMap;
import java.util.Map;

public class GraphWeekVo {
	private Map<String, Integer> weekValues = new HashMap<String, Integer>();

	public int getDayUsage(int day) {
		return weekValues.get(day);
	}

	public void setDayUsage(String day, int usage) {
		weekValues.put(day, usage);
	}

	public Map<String, Integer> getGraphMonthVoMap() {
		return weekValues;
	}
}
