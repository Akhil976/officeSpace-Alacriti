package com.alacriti.officespace.bo;

import java.sql.Connection;

import com.alacriti.officespace.dao.PaginationDao;
import com.alacriti.officespace.vo.PaginationConsumeVo;

public class PaginationBo {

	public static PaginationConsumeVo pagination(Connection connection, PaginationConsumeVo paginationConsumeVo) {
		return PaginationDao.pagiantion(connection, paginationConsumeVo);
	}
	
}
