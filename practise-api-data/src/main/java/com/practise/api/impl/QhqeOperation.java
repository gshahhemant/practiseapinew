package com.practise.api.impl;


import java.util.List;

import com.practise.api.common.model.BaseResponse;
import com.practise.api.model.Qhqe;
import com.practise.api.model.QhqeUserDetails;
import com.practise.api.model.User;
import com.practise.api.model.UserDetailWrapper;
import com.practise.api.model.UserOperation;

public interface QhqeOperation {

	public BaseResponse createUser(QhqeUserDetails qhqeUserDetails);

	public BaseResponse updateUser(QhqeUserDetails qhqeUserDetails);

	public BaseResponse suspendUser(UserOperation user);

	public BaseResponse restoreUser(UserOperation user);

	public BaseResponse<List<UserDetailWrapper>> getQhqeDetail(String qhqeId);

	public BaseResponse<UserDetailWrapper> getUserDetail(String userId);
}
