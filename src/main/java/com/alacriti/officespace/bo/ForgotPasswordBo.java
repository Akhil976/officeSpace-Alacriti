package com.alacriti.officespace.bo;

import java.sql.Connection;

import com.alacriti.officespace.dao.ForgotPasswordDao;
import com.alacriti.officespace.vo.ChangePasswordRequestVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.forgotPasswordResponseVo;

public class ForgotPasswordBo {

	public static forgotPasswordResponseVo emailVerification(Connection connection, String email) {
		return ForgotPasswordDao.emailVerification(connection,email);
	}

	public static ResponseVo changePassword(Connection connection,
			ChangePasswordRequestVo changePasswordRequestVo) {

		return ForgotPasswordDao.changePassword(connection,changePasswordRequestVo);
	}

}
