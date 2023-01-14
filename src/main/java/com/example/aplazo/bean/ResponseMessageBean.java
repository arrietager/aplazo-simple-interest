package com.example.aplazo.bean;

import java.util.List;

public class ResponseMessageBean {
	private boolean success;
	private String message;
	private int requestId;
	private List<ResponseBean> response;
	
	public ResponseMessageBean() {}
	
	public ResponseMessageBean(boolean success, String message, int requestId, List<ResponseBean> response) {
		super();
		this.success = success;
		this.message = message;
		this.requestId = requestId;
		this.response = response;
	}

	public ResponseMessageBean(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public List<ResponseBean> getResponse() {
		return response;
	}
	public void setResponse(List<ResponseBean> response) {
		this.response = response;
	}
	
	@Override
	public String toString() {
		return "ResponseMessageBean [success=" + success + ", message=" + message + ", requestId=" + requestId
				+ ", response=" + response + "]";
	}

}
