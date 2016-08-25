package com.alacriti.officespace.delegate;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import com.alacriti.officespace.bo.LoginBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.LoginRequestVo;
import com.alacriti.officespace.vo.LoginResponseVo;
import com.alacriti.officespace.vo.ResponseVo;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class LoginDelegate {

	public static LoginResponseVo login( LoginRequestVo login) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Connection connection = DbConnection.getConnection();
		return LoginBo.login(connection,login);
	}
}
