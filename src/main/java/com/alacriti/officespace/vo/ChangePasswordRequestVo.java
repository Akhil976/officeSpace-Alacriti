package com.alacriti.officespace.vo;

public class ChangePasswordRequestVo {
	private String code;
	private String password;
	public ChangePasswordRequestVo() {
		super();
	}
	public ChangePasswordRequestVo(String code, String password) {
		super();
		this.code = code;
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ChangePasswordRequestVo [code=" + code + ", password="
				+ password + "]";
	}
	
}
