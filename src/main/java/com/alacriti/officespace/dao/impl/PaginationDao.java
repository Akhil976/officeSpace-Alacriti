package com.alacriti.officespace.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.officespace.vo.ItemConsumeVo;
import com.alacriti.officespace.vo.PaginationConsumeVo;

public class PaginationDao {

	public static PaginationConsumeVo pagiantion(Connection connection, PaginationConsumeVo paginationConsumeVo) {
		System.out.println("in pagenation dao");
		Statement st = null;
		ResultSet rs = null;
		int uniqueId = paginationConsumeVo.getUniqueId();
		int offset = paginationConsumeVo.getOffset();
		int limit = paginationConsumeVo.getLimit();
		PaginationConsumeVo pageConsumeVo = new PaginationConsumeVo();
		try {
			st = connection.createStatement();
			System.out.println("before select");
			System.out.println("select * from officespace_pagination_consume where unique_id = "+uniqueId+" and record_id >= "+offset+" limit "+ limit);
			rs = st.executeQuery("select * from officespace_pagination_consume where unique_id = "+uniqueId+" and record_id >= "+offset+" limit "+ limit);
			System.out.println("after select");
			while(rs.next()){
				System.out.println( rs.getInt("item_id")+"  "+ rs.getInt("catg_id")+"  "+ rs.getString("consume_date")+"  "+ rs.getInt("quantity") );
				ItemConsumeVo itemConsumeVo = new ItemConsumeVo(rs.getInt("item_id"), rs.getInt("catg_id"), rs.getString("consume_date"), rs.getInt("quantity"));
				System.out.println(itemConsumeVo);
				pageConsumeVo.setItemConsumeVo(itemConsumeVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pageConsumeVo.setLimit(limit);
		pageConsumeVo.setOffset(offset);
		pageConsumeVo.setPageNo(paginationConsumeVo.getPageNo());
		pageConsumeVo.setTotalPages(paginationConsumeVo.getTotalPages());
		pageConsumeVo.setUniqueId(uniqueId);
		System.out.println("at page dao: "+pageConsumeVo);
		return pageConsumeVo;
		
	}
	
}
