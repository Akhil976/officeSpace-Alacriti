package com.alacriti.officespace.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

import com.alacriti.officespace.vo.GraphAnalyticsRequestVo;
import com.alacriti.officespace.vo.GraphMonthVo;
import com.alacriti.officespace.vo.GraphWeekVo;
import com.alacriti.officespace.vo.GraphYearVo;

public class GraphDao {
	public static GraphWeekVo getWeekUsage(Connection connection,GraphAnalyticsRequestVo graphAnalyticsRequest) {
		Statement st = null;
		ResultSet rs = null;
		int dayUsage = 0;
		int itemId = graphAnalyticsRequest.getItemId();
		GraphWeekVo graphWeekVo = new GraphWeekVo();
		String calenderValue = graphAnalyticsRequest.getGraphCalValue();
		String[] calenderValues = calenderValue.split("-");
		int month = Integer.parseInt(calenderValues[1]);
		month=month+1;
		calenderValues[1]=month+"";
		int weekStartDate = Integer.parseInt(calenderValues[2]);
		System.out.println(calenderValues);
		try {
			st = connection.createStatement();
			for (int i = 0; i < 7; i++) {
				rs = st.executeQuery("select sum(quantity) from officespace_items_consume_tbl where item_id="+itemId+" and consume_date like '"+calenderValues[0]+"-"+new DecimalFormat("00").format(month)+"-"+new DecimalFormat("00").format((weekStartDate+i))+"'");
				rs.next();
				dayUsage = rs.getInt(1);
				System.out.println(dayUsage);
				graphWeekVo.setDayUsage("w"+(i+1), dayUsage);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return graphWeekVo;
	}
	public static GraphMonthVo getMonthUsage(Connection connection,GraphAnalyticsRequestVo graphAnalyticsRequest) {
		Statement st = null;
		ResultSet rs = null;
		int dayUsage = 0;
		int itemId = graphAnalyticsRequest.getItemId();
		String calenderValue = graphAnalyticsRequest.getGraphCalValue();
		GraphMonthVo graphMonthVo = new GraphMonthVo();
		try {
			st = connection.createStatement();
			for (int i = 1; i < 31; i++) {
				rs = st.executeQuery("select sum(quantity) from officespace_items_consume_tbl where item_id="+itemId+" and consume_date like '"+calenderValue+"-"+new DecimalFormat("00").format(i)+"'");
				rs.next();
				dayUsage = rs.getInt(1);
				System.out.println(dayUsage);
				graphMonthVo.setDayUsage("m"+i, dayUsage);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return graphMonthVo;
	}
	public static GraphYearVo getYearUsage(Connection connection,GraphAnalyticsRequestVo graphAnalyticsRequest) {
		Statement st = null;
		ResultSet rs = null;
		int monthUsage = 0;
		int itemId = graphAnalyticsRequest.getItemId();
		String calenderValue = graphAnalyticsRequest.getGraphCalValue();
		GraphYearVo graphYearVo = new GraphYearVo();
		try {
			st = connection.createStatement();
			for (int i = 1; i <= 12 ; i++) {
				rs = st.executeQuery("select sum(quantity) from officespace_items_consume_tbl where item_id="+itemId+" and consume_date like '"+calenderValue+"-"+new DecimalFormat("00").format(i)+"-%"+"'");
				rs.next();
				monthUsage = rs.getInt(1);
				graphYearVo.setDayUsage("y"+i, monthUsage);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return graphYearVo;
	}
}