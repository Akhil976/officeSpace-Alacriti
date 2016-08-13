package com.alacriti.officespace.delegate;

import java.sql.Connection;
import java.util.ArrayList;

import com.alacriti.officespace.bo.impl.RegisterBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.RegisterUtil;
import com.alacriti.officespace.vo.ResponseVo;

public class RegisterDelegate {
	
	public static ResponseVo addUser(RegisterUtil userInfo){
		Connection connection = DbConnection.getConnection();
		System.out.println("Entereed into delegate layer");
		return RegisterBo.addUser(connection,userInfo);
	}
}
