package com.alacriti.officespace.vo;

public class UserDetailsVo {
	private int userId;
	private String emailId;
	private String firstName;
	private String userRole;

	public UserDetailsVo() {
	}

	public UserDetailsVo(int userId, String firstName, String emailId,
			String userRole) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.emailId = emailId;
		this.userRole = userRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", firstName=" + firstName
				+ ", emailId=" + emailId + ", userRole=" + userRole + "]";
	}

}
