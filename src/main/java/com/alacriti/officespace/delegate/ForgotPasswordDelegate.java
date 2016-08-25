package com.alacriti.officespace.delegate;

import java.sql.Connection;

import com.alacriti.officespace.bo.ForgotPasswordBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.ChangePasswordRequestVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.forgotPasswordResponseVo;

public class ForgotPasswordDelegate {

	public static forgotPasswordResponseVo emailVerification(String email) {
		Connection connection = DbConnection.getConnection();
		return ForgotPasswordBo.emailVerification(connection, email);
	}

	public static ResponseVo changePassword(ChangePasswordRequestVo changePasswordRequestVo) {
		Connection connection = DbConnection.getConnection();
		return ForgotPasswordBo.changePassword(connection, changePasswordRequestVo);
	}

}
