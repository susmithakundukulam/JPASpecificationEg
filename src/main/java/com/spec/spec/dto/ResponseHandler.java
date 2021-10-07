package com.spec.spec.dto;

import java.util.List;

public class ResponseHandler {
	
	private String message;
		
	private List<?> datas;
	
	private Object data;
	
	private boolean isSuccess;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<?> getDatas() {
		return datas;
	}

	public void setDatas(List<?> datas) {
		this.datas = datas;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public ResponseHandler() {}
	
	public ResponseHandler(List<?> datas) {
		this.datas = datas;
	}
	
	public ResponseHandler(Object data, List<Object> datas) {
		this.data = data;
		this.datas = datas;
	}
	
	public ResponseHandler(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public ResponseHandler(String message) {
		this.message = message;
	}
}
