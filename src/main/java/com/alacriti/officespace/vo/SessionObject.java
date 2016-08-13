package com.alacriti.officespace.vo;

public class SessionObject {
	private int userId;
	private String userRole;
	
	public SessionObject() {
	}

	public SessionObject(int userId, String userRole) {
		super();
		this.userId = userId;
		this.userRole = userRole;
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
		return "SessionObject [userId=" + userId + ", userRole=" + userRole
				+ "]";
	}
	
	
	
}
