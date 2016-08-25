package com.alacriti.officespace.dao;

import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alacriti.officespace.vo.ChangePasswordRequestVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.forgotPasswordResponseVo;

public class ForgotPasswordDao {

	public static forgotPasswordResponseVo emailVerification(Connection connection, String email) {
		Statement st = null;
		ResultSet rs = null;
		forgotPasswordResponseVo responseVo = new forgotPasswordResponseVo();
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select email_id from officespace_user_dtls_tbl");
			while(rs.next()){
				if(rs.getString(1) != null){
					if(rs.getString(1).equals(email)){
						responseVo.setSuccess(true);
						String randomCode = generateRandomNumber();
						responseVo.setCode(randomCode);
						st.executeUpdate("insert into officespace_forgot_password values('"+email+"','"+randomCode+"')");
						return responseVo;
					}
				}
			}
			responseVo.setSuccess(false);
			return responseVo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return responseVo;
	}
	public static String generateRandomNumber() {
	    List<Integer> numbers = new ArrayList<>();
	    for(int i = 0; i < 10; i++){
	        numbers.add(i);
	    }

	    Collections.shuffle(numbers);

	    String result = "";
	    for(int i = 0; i < 4; i++){
	        result += numbers.get(i).toString();
	    }
	    return result;
	}
	public static ResponseVo changePassword(Connection connection,
			ChangePasswordRequestVo changePasswordRequestVo) {
		Statement st = null;
		ResultSet rs = null;
		String code=changePasswordRequestVo.getCode();
		String password = changePasswordRequestVo.getPassword();
		ResponseVo responseVo = new ResponseVo();
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select code from officespace_forgot_password;");
			while(rs.next()){
				System.out.println(rs.getString(1));
				if(rs.getString(1) != null){
					if(rs.getString(1).equals(code)){
						rs = st.executeQuery("select email_id from officespace_forgot_password where code='"+code+"'");
						rs.next();
						String email =rs.getString(1); 
						st.executeUpdate("UPDATE officespace_user_dtls_tbl SET pass_word ='"+password+"' WHERE email_id='"+email+"'");
						responseVo.setSuccess(true);
						return responseVo;
					}
				}
			}
			responseVo.setSuccess(false);
			return responseVo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return responseVo;
	}
}
