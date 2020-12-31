package com.practise.api.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QHQE_USER")
public class QhqeUserEntity implements Serializable {

	private static final long serialVersionUID = -4093039825520183017L;

	@Id
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="MID_NAME")
	private String midName;
	
	@Column(name="PH_NUM")
	private String phNum;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="QHQE_ID")
	private String qhqeId;
	
	@Column(name="QHQE_NAME")
	private String qhqeName;
	
	@Column(name="QHQE_TYPE")
	private String qhqeType;
	
	@Column(name="USER_ACTIVE_SW")
	private String activerUser;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="CREATED_DT")
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_DT")
	private LocalDateTime updatedDate;
					
	public QhqeUserEntity() {
		
	}

	public QhqeUserEntity(String userId, String firstName, String lastName, String midName, String phNum, String email,
			String qhqeId, String qhqeName, String qhqeType, String activerUser, String createdBy, String updatedBy,
			LocalDateTime createdDate, LocalDateTime updatedDate) {
	
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
		this.phNum = phNum;
		this.email = email;
		this.qhqeId = qhqeId;
		this.qhqeName = qhqeName;
		this.qhqeType = qhqeType;
		this.activerUser = activerUser;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		this.email = email;
	}

	public String getQhqeId() {
		return qhqeId;
	}

	public void setQhqeId(String qhqeId) {
		this.qhqeId = qhqeId;
	}

	public String getQhqeName() {
		return qhqeName;
	}

	public void setQhqeName(String qhqeName) {
		this.qhqeName = qhqeName;
	}

	public String getQhqeType() {
		return qhqeType;
	}

	public void setQhqeType(String qhqeType) {
		this.qhqeType = qhqeType;
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
