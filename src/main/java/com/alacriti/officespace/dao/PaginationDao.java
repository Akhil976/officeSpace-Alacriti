package com.alacriti.officespace.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.officespace.vo.ItemConsumeVo;
import com.alacriti.officespace.vo.PaginationConsumeVo;

public class PaginationDao {

	public static PaginationConsumeVo pagiantion(Connection connection, PaginationConsumeVo paginationConsumeVo) {
		Statement st = null;
		ResultSet rs = null;
		int uniqueId = paginationConsumeVo.getUniqueId();
		int offset = paginationConsumeVo.getOffset();
		int limit = paginationConsumeVo.getLimit();
		PaginationConsumeVo pageConsumeVo = new PaginationConsumeVo();
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select * from officespace_pagination_consume where unique_id = "+uniqueId+" and record_id >= "+offset+" limit "+ limit);
			while(rs.next()){
				ItemConsumeVo itemConsumeVo = new ItemConsumeVo(rs.getInt("item_id"), rs.getInt("catg_id"), rs.getString("consume_date"), rs.getInt("quantity"));
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
		return pageConsumeVo;
		
	}
	
}
