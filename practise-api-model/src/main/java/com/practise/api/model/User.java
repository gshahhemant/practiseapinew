package com.practise.api.model;

import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.StringUtils;

public class User {

	@NotEmpty(message = "User id is mandatory.")
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = StringUtils.trim(userId);
	}
}
