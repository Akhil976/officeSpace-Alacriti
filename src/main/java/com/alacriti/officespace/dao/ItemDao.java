package com.alacriti.officespace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.alacriti.officespace.vo.AnalyticsTotal;
import com.alacriti.officespace.vo.Category;
import com.alacriti.officespace.vo.CategoryVo;

public class ItemDao {
	
	static final String DB_URL = "jdbc:mysql://192.168.35.70:3306/trainee_dev";
	static final String USER_NAME = "trainee_dev";
	static final String PASSWORD = "trainee_dev";

	public static int getCapacity(Connection connection, int itemId){
		try( Statement st = connection.createStatement()) {
			ResultSet rs = st.executeQuery("select max_capacity from officespace_items_tbl where item_id="+itemId);
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static int getAvailableItems(Connection connection, int itemId){
		int consumeAmount=0;
		int purchaseAmount=0;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();	
			rs = st.executeQuery("select sum(quantity) c from officespace_items_consume_tbl where item_id="+itemId);
			rs.next();
			consumeAmount=rs.getInt(1);
			rs = st.executeQuery("select sum(quantity) c from officespace_items_purchase_tbl where item_id="+itemId);
			rs.next();
			purchaseAmount=rs.getInt(1);
			if(consumeAmount==0){
				if(purchaseAmount>0){
					return purchaseAmount;
				}
				else{
					return 0;
				}
			}
			else{
				rs = st.executeQuery("select b.a - d.c as availability from (select sum(quantity) a from officespace_items_purchase_tbl where item_id="+itemId+") b, (select sum(quantity) c from officespace_items_consume_tbl where item_id="+itemId+") d;");
				rs.next();
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;	
	}	
//Analytics
	public static AnalyticsTotal getAnalytics(Connection connection, int itemId){
		AnalyticsTotal analytics = new AnalyticsTotal();
		Statement st = null;
		try {
			st = connection.createStatement();
			
			ResultSet dayRs = st.executeQuery("select sum(quantity)/count(consume_date) as dayAverage from officespace_items_consume_tbl where item_id ="+itemId);
			dayRs.next();
			analytics.setAnalyticsDay(Math.round(dayRs.getFloat("dayAverage")));
			dayRs.close();
	
	    	ResultSet weekRs = st.executeQuery("select sum(x.q)/ y.c weekAverage from (select sum(quantity) q from officespace_items_consume_tbl where item_id ="+itemId+" group by date_format(consume_date, '%u-%c-%y')) x, (select count( distinct date_format(consume_date, '%u-%c-%y')) c from officespace_items_consume_tbl where item_id = "+itemId+") y");
			weekRs.next();
	    	analytics.setAnalyticsWeek(Math.round( weekRs.getFloat("weekAverage") ));
			weekRs.close();
			//Month
			ResultSet monthRs = st.executeQuery("select sum(x.q)/ y.c monthAverage from (select sum(quantity) q from officespace_items_consume_tbl where item_id ="+itemId+" group by date_format(consume_date, '%c-%y')) x, (select count( distinct date_format(consume_date, '%c-%y')) c from officespace_items_consume_tbl where item_id ="+itemId+") y");
			monthRs.next();
			analytics.setAnalyticsMonth(Math.round( monthRs.getFloat("monthAverage")));
			monthRs.close();
			//Year
			ResultSet yearRs = st.executeQuery("select sum(x.q)/ y.c yearAverage from (select sum(quantity) q from officespace_items_consume_tbl where item_id = "+itemId+" group by date_format(consume_date, '%Y')) x, (select count( distinct date_format(consume_date, '%Y')) c from officespace_items_consume_tbl where item_id = "+itemId+") y");
			yearRs.next();
			analytics.setAnalyticsYear(Math.round( yearRs.getFloat("yearAverage")));
			yearRs.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return analytics;
	}
	public static ArrayList<CategoryVo> getCategories(Connection connection, int itemId) {
		ArrayList<CategoryVo> categoryList = new ArrayList<CategoryVo>();
		try(Statement st = connection.createStatement();) {
			ResultSet rs = st.executeQuery("select catg_id,catg_name from officespace_items_catg_tbl");
			while(rs.next()){
				categoryList.add( new CategoryVo( rs.getInt("catg_id"), rs.getString("catg_name") ) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
}
