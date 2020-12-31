package com.practise.api.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.practise.api.common.model.BaseResponse;
import com.practise.api.common.model.ErrorDetail;
import com.practise.api.common.model.Status;

public class UserProServiceException extends RuntimeException {

	private BaseResponse baseResponse;

	public UserProServiceException() {
		baseResponse = new BaseResponse();
	}

	public UserProServiceException(String responseMessage) {

		baseResponse = new BaseResponse();
		baseResponse.setRespCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		baseResponse.setStatus(Status.FAIL);
		baseResponse.setRespMessage(responseMessage);
	}

	public UserProServiceException(List<ErrorDetail> errorDetail) {

		baseResponse = new BaseResponse();
		baseResponse.setRespCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		baseResponse.setStatus(Status.FAIL);
		baseResponse.setErrorDetail(errorDetail);
	}

	public BaseResponse getBaseResponse() {
		return baseResponse;
	}

	public void setBaseResponse(BaseResponse baseResponse) {
		this.baseResponse = baseResponse;
	}

}
