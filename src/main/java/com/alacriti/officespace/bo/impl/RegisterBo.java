package com.alacriti.officespace.bo.impl;

import java.sql.Connection;

import com.alacriti.officespace.dao.impl.RegisterDao;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.RegisterUtil;
import com.alacriti.officespace.vo.ResponseVo;

public class RegisterBo {

	public static ResponseVo addUser(Connection connection, RegisterUtil userInfo) {
		System.out.println("entered into business layer");
		return RegisterDao.addUser(connection,userInfo);
	}
}