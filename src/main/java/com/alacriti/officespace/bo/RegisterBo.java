package com.alacriti.officespace.bo;

import java.sql.Connection;

import com.alacriti.officespace.dao.RegisterDao;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.RegisterUtil;
import com.alacriti.officespace.vo.ResponseVo;

public class RegisterBo {

	public static ResponseVo addUser(Connection connection, RegisterUtil userInfo) {
		return RegisterDao.addUser(connection,userInfo);
	}
}