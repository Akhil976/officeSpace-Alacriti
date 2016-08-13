package com.alacriti.officespace.vo;

public class ResponseVo {
	private boolean success;

	public ResponseVo() {
	}

	public ResponseVo(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ResponseVo [success=" + success + "]";
	}

}
