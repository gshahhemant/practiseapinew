package com.practise.api.model;

import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.StringUtils;

public class Qhqe {

	@NotEmpty(message = "qhqe id is mandatory.")
	private String qhqeId;

	public String getQhqeId() {
		return qhqeId;
	}

	public void setQhqeId(String qhqeId) {
		this.qhqeId = StringUtils.trim(qhqeId);
	}

}
