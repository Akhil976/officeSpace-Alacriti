package com.alacriti.officespace.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import com.alacriti.officespace.delegate.PaginationDelegate;
import com.alacriti.officespace.resource.RegisterResource;
import com.alacriti.officespace.vo.AnalyticsRequestVo;
import com.alacriti.officespace.vo.PaginationConsumeVo;
import com.alacriti.officespace.vo.PaginationRequestVo;

public class AnalyticsDao {
	private static int uniqueId = 1;
	public static int getDayUsage(Connection connection,AnalyticsRequestVo analyticsCustom) {
		Statement st = null;
		ResultSet rs = null;
		int dayUsage = 0;
		int itemId = analyticsCustom.getItemId();
		String calenderValue = analyticsCustom.getCalenderValue();
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select sum(quantity) from officespace_items_purchase_tbl where item_id="+itemId+" and purchase_date like '"+calenderValue+"'");
			rs.next();
			dayUsage = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dayUsage;
	}
	public static int getWeekUsage(Connection connection,AnalyticsRequestVo analyticsCustom) {
		Statement st = null;
		ResultSet rs = null;
		int weekUsage = 0;
		int itemId = analyticsCustom.getItemId();
		String calenderValue = analyticsCustom.getCalenderValue();
		calenderValue = calenderValue.replace("W","");
		String[] calenderValues = calenderValue.split("-");
		try {
			st = connection.createStatement();
			System.out.println("select sum(quantity) as quantity from officespace_items_purchase_tbl where DATE_FORMAT(purchase_date, '%u')="+calenderValues[1]+" and DATE_FORMAT(purchase_date, '%Y')="+calenderValues[0]+" and item_id="+itemId);
			rs = st.executeQuery("select sum(quantity) as quantity from officespace_items_purchase_tbl where DATE_FORMAT(purchase_date, '%u')="+calenderValues[1]+" and DATE_FORMAT(purchase_date, '%Y')="+calenderValues[0]+" and item_id="+itemId);
			rs.next();
			weekUsage = rs.getInt(1);
			System.out.println(weekUsage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return weekUsage;
	}
	public static int getMonthUsage(Connection connection,AnalyticsRequestVo analyticsCustom) {
		Statement st = null;
		ResultSet rs = null;
		int monthUsage = 0;
		int itemId = analyticsCustom.getItemId();
		String calenderValue = analyticsCustom.getCalenderValue();
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select sum(quantity) from officespace_items_purchase_tbl where item_id=8002 and purchase_date like '"+calenderValue+"-%';");
			rs.next();
			monthUsage = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return monthUsage;
	}
	public static int getYearUsage(Connection connection,AnalyticsRequestVo analyticsCustom) {
		Statement st = null;
		ResultSet rs = null;
		int yearUsage = 0;
		int itemId = analyticsCustom.getItemId();
		String calenderValue = analyticsCustom.getCalenderValue();
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select sum(quantity) from officespace_items_purchase_tbl where item_id=8002 and purchase_date like '"+calenderValue+"-%';");
			rs.next();
			yearUsage = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return yearUsage;
	}
	public static PaginationConsumeVo getPagination(Connection connection, PaginationRequestVo paginationRequestVo){
		int itemId = paginationRequestVo.getItemId();
		int categoryId = paginationRequestVo.getCategoryId();
		String date = paginationRequestVo.getDate();
		PaginationConsumeVo paginationConsumeVo = new PaginationConsumeVo();
		String calenderValue;
		int consumeQuantity;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			for(int i=1; i<31; i++){
				calenderValue = date+"-"+new DecimalFormat("00").format(i);
				
				rs = st.executeQuery("select sum(quantity) as consumeQuantity from officespace_items_consume_tbl where item_id="+itemId+" and consume_date like '"+calenderValue+"'");
				rs.next();
				consumeQuantity = rs.getInt("consumeQuantity");
				rs.close();

				
				st.executeUpdate("insert into officespace_pagination_consume values("+itemId+","+categoryId+",'"+calenderValue+"',"+consumeQuantity+","+uniqueId+","+i+")");
				
			}
			rs = st.executeQuery("SELECT COUNT(*) FROM officespace_pagination_consume where unique_id= "+uniqueId);
			rs.next();
			System.out.println("total rows: "+rs.getInt(1));
			int totalPages = (int) (rs.getInt(1)/5);
			System.out.println(totalPages);
			paginationConsumeVo.setTotalPages(totalPages);
			paginationConsumeVo.setLimit(5);
			paginationConsumeVo.setOffset(1);
			paginationConsumeVo.setPageNo(1);
			paginationConsumeVo.setUniqueId(uniqueId);
			uniqueId++;
			//paginationConsumeVo = PaginationDelegate.pagination(paginationConsumeVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paginationConsumeVo;
	}
	
	
}
