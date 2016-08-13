package com.alacriti.officespace.delegate;

import java.sql.Connection;

import com.alacriti.officespace.bo.impl.PaginationBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.PaginationConsumeVo;

public class PaginationDelegate {
	
	public static PaginationConsumeVo pagination(PaginationConsumeVo paginationConsumeVo) {
		System.out.println("in pagination delegate");
		Connection connection = DbConnection.getConnection();
		return PaginationBo.pagination(connection,paginationConsumeVo);
	}
	
}
