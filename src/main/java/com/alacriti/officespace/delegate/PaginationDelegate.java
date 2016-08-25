package com.alacriti.officespace.delegate;

import java.sql.Connection;

import com.alacriti.officespace.bo.PaginationBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.PaginationConsumeVo;

public class PaginationDelegate {
	
	public static PaginationConsumeVo pagination(PaginationConsumeVo paginationConsumeVo) {
		Connection connection = DbConnection.getConnection();
		return PaginationBo.pagination(connection,paginationConsumeVo);
	}
	
}
