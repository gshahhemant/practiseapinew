package com.practise.api.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practise.api.common.model.BaseResponse;
import com.practise.api.model.QhqeUserDetails;
import com.practise.api.model.UserDetailWrapper;
import com.practise.api.model.UserOperation;
import com.practise.api.service.QhqeService;

/**
 * @author hshah02
 * 
 */
@RestController
@RequestMapping(value = "/data/qhqeacct")
public class QhqeController {

	@Autowired
	QhqeService qhqeService;

	@PostMapping(value = "/user")
	public @ResponseBody ResponseEntity<BaseResponse> createUser(@Valid @RequestBody QhqeUserDetails QhqeUserDetails) {

		return new ResponseEntity<BaseResponse>(qhqeService.createUser(QhqeUserDetails), HttpStatus.OK);
	}

	@PutMapping(value = "/user")
	public @ResponseBody ResponseEntity<BaseResponse> updateUser(@Valid @RequestBody QhqeUserDetails QhqeUserDetails) {

		return new ResponseEntity<BaseResponse>(qhqeService.updateUser(QhqeUserDetails), HttpStatus.OK);
	}

	@PutMapping(value = "/suspend-user")
	public @ResponseBody ResponseEntity<BaseResponse> suspendUser(@Valid @RequestBody UserOperation user) {

		return new ResponseEntity<BaseResponse>(qhqeService.suspendUser(user), HttpStatus.OK);
	}

	@PutMapping(value = "/restore-user")
	public @ResponseBody ResponseEntity<BaseResponse> restoreUser(@Valid @RequestBody UserOperation user) {

		return new ResponseEntity<BaseResponse>(qhqeService.restoreUser(user), HttpStatus.OK);
	}

	@GetMapping(value = "/user/{userid}")
	public @ResponseBody ResponseEntity<BaseResponse<UserDetailWrapper>> getUser(
			@PathVariable("userid") @Min(1) @Max(10) String userid) {

		return new ResponseEntity<BaseResponse<UserDetailWrapper>>(qhqeService.getUser(userid), HttpStatus.OK);
	}

	@GetMapping(value = "/qhqe/{qhqeid}")
	public @ResponseBody ResponseEntity<BaseResponse<List<UserDetailWrapper>>> getQhqeDetail(
			@PathVariable("qhqeid") String qhqeid) {

		return new ResponseEntity<BaseResponse<List<UserDetailWrapper>>>(qhqeService.getQhqeDetail(qhqeid),
				HttpStatus.OK);
	}

}
