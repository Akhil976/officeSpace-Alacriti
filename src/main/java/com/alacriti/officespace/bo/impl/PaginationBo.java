package com.alacriti.officespace.bo.impl;

import java.sql.Connection;

import com.alacriti.officespace.dao.impl.PaginationDao;
import com.alacriti.officespace.vo.PaginationConsumeVo;

public class PaginationBo {

	public static PaginationConsumeVo pagination(Connection connection, PaginationConsumeVo paginationConsumeVo) {
		System.out.println("in paginatyion BO");
		return PaginationDao.pagiantion(connection, paginationConsumeVo);
	}
	
}
