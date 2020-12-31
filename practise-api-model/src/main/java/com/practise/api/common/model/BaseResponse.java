package com.practise.api.common.model;

import java.util.List;

public class BaseResponse<T> {

	private Status status;
	private String respMessage;
	private int respCode;
	private List<ErrorDetail> errorDetail;
	private T data;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getRespMessage() {
		return respMessage;
	}

	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}

	public int getRespCode() {
		return respCode;
	}

	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}

	public List<ErrorDetail> getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(List<ErrorDetail> errorDetail) {
		this.errorDetail = errorDetail;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
