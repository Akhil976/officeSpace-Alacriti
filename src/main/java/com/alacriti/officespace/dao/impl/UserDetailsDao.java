package com.alacriti.officespace.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.officespace.vo.LoginRequestVo;
import com.alacriti.officespace.vo.UserDetailsVo;

public class UserDetailsDao {

	public static UserDetailsVo getUserDetails(Connection connection, LoginRequestVo login) {
		
		Statement st = null;
		ResultSet rs = null;
		UserDetailsVo userDetailsVo = new UserDetailsVo();
		try {
			st = connection.createStatement();
			System.out.println("select user_id,email_id,first_name,user_role from officespace_user_dtls_tbl where email_id='"+login.getEmail_id()+"'");
			rs = st.executeQuery("select user_id,email_id,first_name,user_role from officespace_user_dtls_tbl where email_id='"+login.getEmail_id()+"'");
			while(rs.next()){
				System.out.println("in loop");
				userDetailsVo.setUserId(rs.getInt(1));
				userDetailsVo.setEmailId(rs.getString(2));
				userDetailsVo.setFirstName(rs.getString(3));
				userDetailsVo.setUserRole(rs.getString(4));
			}
			System.out.println(userDetailsVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userDetailsVo;
	}
}
