package com.alacriti.officespace.resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.alacriti.officespace.delegate.ForgotPasswordDelegate;
import com.alacriti.officespace.util.GenerateFtlResponse;
import com.alacriti.officespace.util.TLSsend;
import com.alacriti.officespace.vo.ChangePasswordRequestVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.forgotPasswordResponseVo;

@Path("/forgotPassword")
public class ForgotPasswordResource {
	@POST
	@Path("/email")
	public String emailVerification(@FormParam("fpEmail") String email){
		forgotPasswordResponseVo responseVo = ForgotPasswordDelegate.emailVerification(email);
		if(responseVo.isSuccess() == true){
			if(TLSsend.sending(email,responseVo.getCode())){
				return GenerateFtlResponse.getVerificationCode();
			}
		}
		else{
			return null;
		}
		return null;
	}
	@POST
	@Path("/changePassword")
	public String changePassword(@FormParam("verificationCode") String verificationCode,
				@FormParam("newPassword") String newPassword
				 ){
		ChangePasswordRequestVo changePasswordRequestVo = new ChangePasswordRequestVo();
		changePasswordRequestVo.setCode(verificationCode);
		changePasswordRequestVo.setPassword(newPassword);
		
		ResponseVo responseVo = ForgotPasswordDelegate.changePassword(changePasswordRequestVo);
		if(responseVo.isSuccess()==true){
			return GenerateFtlResponse.getPasswordSuccessCode();
		}
		else{
			return null;
		}
	}
}
