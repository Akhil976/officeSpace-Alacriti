package com.alacriti.officespace.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.officespace.vo.RegisterUtil;
import com.alacriti.officespace.vo.ResponseVo;

public class RegisterDao {
	public static ResponseVo addUser(Connection connection, RegisterUtil userInfo){
		Statement st = null;
		ResponseVo responseVo = new ResponseVo();
		//inserting data
		String pass_word=userInfo.getPass_word();
		String first_name=userInfo.getFirst_name();
		String last_name=userInfo.getLast_name();
		String email_id=userInfo.getEmail_id();
		String contact_number=userInfo.getContact_number();
		String user_role=userInfo.getUser_role();

		try {
			st = connection.createStatement();
			st.executeUpdate("insert into officespace_user_dtls_tbl(pass_word,first_name,last_name,email_id,contact_number,user_role) values ('"+pass_word+"','"+first_name+"','"+last_name+"','"+email_id+"','"+contact_number+"','"+user_role+"')");
			responseVo.setSuccess(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseVo.setSuccess(false);
		}
		return responseVo;
	}
}
