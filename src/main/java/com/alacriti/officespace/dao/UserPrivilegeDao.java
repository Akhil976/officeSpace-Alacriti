package com.alacriti.officespace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.alacriti.officespace.vo.LoginRequestVo;

public class UserPrivilegeDao {
	
	static final String DB_URL = "jdbc:mysql://192.168.35.70:3306/trainee_dev";
	static final String USER_NAME = "trainee_dev";
	static final String PASSWORD = "trainee_dev";

	public static ArrayList<Integer> getUserPrivileges(int userId){
		try(Connection conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery("select privilege_id from officespace_user_privilege_tbl where user_id="+userId);
			ArrayList<Integer> userPrivileges = new ArrayList<Integer>();
			while (rs.next()){
				userPrivileges.add(rs.getInt(1));
			}
			return userPrivileges;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
