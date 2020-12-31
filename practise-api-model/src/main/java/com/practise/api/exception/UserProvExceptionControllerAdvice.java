package com.practise.api.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.practise.api.common.model.BaseResponse;
import com.practise.api.common.model.ErrorDetail;
import com.practise.api.common.model.Status;


@ControllerAdvice
public class UserProvExceptionControllerAdvice extends ResponseEntityExceptionHandler {

	

	@ExceptionHandler(UserProServiceException.class)
	public ResponseEntity<BaseResponse> handleExceptionPeException(UserProServiceException exception) {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<BaseResponse>(exception.getBaseResponse(), responseHeaders, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<BaseResponse> processException(Exception ex) {

	
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		BaseResponse baseResponse = new BaseResponse();

		baseResponse.setRespMessage("General error during api call");
		baseResponse.setStatus(Status.FAIL);
		baseResponse.setRespCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<BaseResponse>(baseResponse, responseHeaders, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		
		BaseResponse baseResponse = new BaseResponse();
		List<ErrorDetail> errorDetails = new ArrayList<ErrorDetail>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {

			
			ErrorDetail errorDetail = new ErrorDetail();
			errorDetail.setErrorMessage(error.getDefaultMessage());
			errorDetail.setErrorDescription(error.getDefaultMessage());
			errorDetails.add(errorDetail);

		});

		baseResponse.setErrorDetail(errorDetails);
		baseResponse.setRespMessage("One or more validation failed.");
		baseResponse.setStatus(Status.FAIL);
		baseResponse.setRespCode(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<Object>(baseResponse, headers, HttpStatus.BAD_REQUEST);

	}

}
