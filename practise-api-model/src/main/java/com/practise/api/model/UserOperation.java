package com.practise.api.model;

import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.StringUtils;

public class UserOperation extends User {

	@NotEmpty(message = "Operation By is mandatory.")
	private String operationBy;

	public String getOperationBy() {
		return operationBy;
	}

	public void setOperationBy(String operationBy) {
		this.operationBy = StringUtils.trim(operationBy);
	}

}
