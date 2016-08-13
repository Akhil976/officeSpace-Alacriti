package com.alacriti.officespace.vo;

public class LoginResponseVo {
	
	private boolean success;
	private int userId;
	private String userRole;

	public LoginResponseVo() {
	}

	public LoginResponseVo(boolean success, int userId, String userRole) {
		super();
		this.success = success;
		this.userId = userId;
		this.userRole = userRole;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "LoginResponseVo [success=" + success + ", userId=" + userId
				+ ", userRole=" + userRole + "]";
	}

}
