package com.practise.api.model;

import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.StringUtils;

public class QhqeUserDetails extends User {

	@NotEmpty(message = "First Name is mandatory.")
	private String firstName;
	@NotEmpty(message = "Last Name is mandatory.")
	private String lastName;
	private String midName;
	private String phNum;
	@NotEmpty(message = "Email id is mandatory.")
	private String email;
	@NotEmpty(message = "Qhqe Id is mandatory.")
	private String qhqeId;
	@NotEmpty(message = "Qhqe Name is mandatory.")
	private String qhqeName;
	@NotEmpty(message = "Qhqe Type is mandatory.")
	private String qhqeType;
	@NotEmpty(message = "Operation By is mandatory.")
	private String operationBy;

	public QhqeUserDetails() {
	}

	public QhqeUserDetails(String userId, String firstName, String lastName, String midName, String phNum, String email,
			String qhqeId, String qhqeName, String qhqeType) {

		this.setUserId(userId);
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
		this.phNum = phNum;
		this.email = email;
		this.qhqeId = qhqeId;
		this.qhqeName = qhqeName;
		this.qhqeType = qhqeType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = StringUtils.trim(firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = StringUtils.trim(lastName);
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getPhNum() {
		return phNum;
	}

	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = StringUtils.trim(email);
	}

	public String getQhqeId() {
		return qhqeId;
	}

	public void setQhqeId(String qhqeId) {
		this.qhqeId = StringUtils.trim(qhqeId);
	}

	public String getQhqeName() {
		return qhqeName;
	}

	public void setQhqeName(String qhqeName) {
		this.qhqeName = StringUtils.trim(qhqeName);
	}

	public String getQhqeType() {
		return qhqeType;
	}

	public void setQhqeType(String qhqeType) {
		this.qhqeType = StringUtils.trim(qhqeType);
	}

	public String getOperationBy() {
		return operationBy;
	}

	public void setOperationBy(String operationBy) {
		this.operationBy = StringUtils.trim(operationBy);
	}

}
