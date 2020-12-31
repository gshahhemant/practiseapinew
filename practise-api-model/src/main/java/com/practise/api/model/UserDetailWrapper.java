package com.practise.api.model;

public class UserDetailWrapper {

	private QhqeUserDetails qhqeUserDetails;
	private QhqeAudit qhqeAudit;

	public QhqeUserDetails getQhqeUserDetails() {
		return qhqeUserDetails;
	}

	public void setQhqeUserDetails(QhqeUserDetails qhqeUserDetails) {
		this.qhqeUserDetails = qhqeUserDetails;
	}

	public QhqeAudit getQhqeAudit() {
		return qhqeAudit;
	}

	public void setQhqeAudit(QhqeAudit qhqeAudit) {
		this.qhqeAudit = qhqeAudit;
	}

}
