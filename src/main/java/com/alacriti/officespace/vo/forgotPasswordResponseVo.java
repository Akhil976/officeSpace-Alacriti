package com.alacriti.officespace.vo;

public class forgotPasswordResponseVo {

		private boolean success;
		private String code;
		
		public forgotPasswordResponseVo() {
		}

		public forgotPasswordResponseVo(boolean success, String code) {
			super();
			this.success = success;
			this.code = code;
		}

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}
		
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return "forgotPasswordResponseVo [success=" + success + ", code="
					+ code + "]";
		}

}
