package com.alacriti.officespace.vo;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
public class RegisterUtil {
	
	private String first_name;
	private String last_name;
	private String email_id;
	private String contact_number;
	private String pass_word;
	private String confirmPass_word;
	private String user_role;

	public RegisterUtil() {
	}
	public RegisterUtil(String first_name, String last_name, String email_id,
			String contact_number, String pass_word, String confirmPass_word, String user_role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.contact_number = contact_number;
		this.pass_word = pass_word;
		this.confirmPass_word = confirmPass_word;
		this.user_role = user_role;
		
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	public String getConfirmPass_word() {
		return confirmPass_word;
	}
	public void setConfirmPass_word(String confirmPass_word) {
		this.confirmPass_word = confirmPass_word;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
}
