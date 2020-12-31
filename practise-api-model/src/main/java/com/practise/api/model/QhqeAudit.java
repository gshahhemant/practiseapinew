package com.practise.api.model;

import java.time.LocalDateTime;

public class QhqeAudit {

	private String createdBy;
	private String updatedBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private String activerUser;

	public QhqeAudit() {
	}

	public QhqeAudit(String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate,String activerUser) {
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.activerUser= activerUser;
	}
			
	public String getActiverUser() {
		return activerUser;
	}

	public void setActiverUser(String activerUser) {
		this.activerUser = activerUser;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

}
