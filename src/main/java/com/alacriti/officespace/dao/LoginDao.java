package com.alacriti.officespace.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.alacriti.officespace.vo.LoginRequestVo;

public class LoginDao {

	public static ArrayList<LoginRequestVo> getDbLogDetails(Connection connection) {
		Statement st = null;
		ResultSet rs = null;
		ArrayList<LoginRequestVo> dbLogDetails = new ArrayList<LoginRequestVo>();
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select email_id,pass_word from officespace_user_dtls_tbl");
			while (rs.next()) {
				dbLogDetails.add(new LoginRequestVo(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbLogDetails;
	}
}
