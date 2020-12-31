package com.practise.api.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.practise.api.common.model.BaseResponse;
import com.practise.api.common.model.ErrorDetail;
import com.practise.api.common.model.Status;
import com.practise.api.impl.QhqeOperation;
import com.practise.api.model.Qhqe;
import com.practise.api.model.QhqeUserDetails;
import com.practise.api.model.UserDetailWrapper;
import com.practise.api.model.UserOperation;

@Service
public class QhqeService {

	@Autowired
	QhqeOperation qhqeOperation;

	public BaseResponse createUser(QhqeUserDetails qhqeUserDetails) {

		return qhqeOperation.createUser(qhqeUserDetails);
	}

	public BaseResponse updateUser(QhqeUserDetails qhqeUserDetails) {

		return qhqeOperation.updateUser(qhqeUserDetails);
	}

	public BaseResponse suspendUser(UserOperation qhqeUser) {

		return qhqeOperation.suspendUser(qhqeUser);
	}

	public BaseResponse restoreUser(UserOperation qhqeUser) {

		return qhqeOperation.restoreUser(qhqeUser);
	}

	public BaseResponse<List<UserDetailWrapper>> getQhqeDetail(String qhqeId) {
		return qhqeOperation.getQhqeDetail(qhqeId);
	}

	public BaseResponse<UserDetailWrapper> getUser(String userId) {
		return qhqeOperation.getUserDetail(userId);
	}

}
