package com.alacriti.officespace.bo;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import com.alacriti.officespace.dao.LoginDao;
import com.alacriti.officespace.dao.UserDetailsDao;
import com.alacriti.officespace.vo.LoginResponseVo;
import com.alacriti.officespace.vo.LoginRequestVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.UserDetailsVo;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class LoginBo {
	public static LoginResponseVo login(Connection connection, LoginRequestVo login) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		
		ArrayList<LoginRequestVo> dbLogDetails = LoginDao.getDbLogDetails(connection);
		LoginResponseVo loginResponseVo = new LoginResponseVo();
		
		for(int i=0;i<dbLogDetails.size();i++){
			if(dbLogDetails.get(i).getEmail_id().equals(login.getEmail_id())){
				if(dbLogDetails.get(i).getPass_word().equals(login.getPass_word())){
					UserDetailsVo userDetails = UserDetailsDao.getUserDetails(connection,login);
					loginResponseVo.setSuccess(true);
					loginResponseVo.setUserId(userDetails.getUserId());
					loginResponseVo.setUserRole(userDetails.getUserRole());
					
					return loginResponseVo;
					}
				
				}
		}//forloop
		loginResponseVo.setSuccess(false);
		return loginResponseVo;
	}
}