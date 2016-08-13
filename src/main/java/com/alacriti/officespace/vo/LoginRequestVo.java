package com.alacriti.officespace.vo;

public class LoginRequestVo {
	private String email_id;
	private String pass_word;

	public LoginRequestVo(){
	}
	public LoginRequestVo(String email_id, String pass_word) {
		super();
		this.email_id = email_id;
		this.pass_word = pass_word;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
}
