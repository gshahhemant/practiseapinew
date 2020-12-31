package com.practise.api.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.practise.api.common.Messages;
import com.practise.api.common.UserProvConstant;
import com.practise.api.common.model.BaseResponse;
import com.practise.api.common.model.Status;
import com.practise.api.exception.UserProServiceException;
import com.practise.api.jpa.entity.QhqeUserEntity;
import com.practise.api.model.QhqeUserDetails;
import com.practise.api.model.UserDetailWrapper;
import com.practise.api.model.UserOperation;
import com.practise.api.repositories.QhqeRepository;
import com.practise.api.translator.QhqeUserTranslator;

@Component
public class QhqeOperationImpl implements QhqeOperation {

	private static final String className = QhqeOperationImpl.class.getCanonicalName();

	@Autowired
	QhqeRepository qhqeRepository;

	@Autowired
	QhqeUserTranslator qhqeUserTranslator;

	@Autowired
	Messages message;

	@Override
	public BaseResponse createUser(QhqeUserDetails qhqeUserDetails) {
		try {
			BaseResponse baseResponse = new BaseResponse();

			if (isUserExist(qhqeUserDetails.getUserId()))
				return userExist(baseResponse);

			QhqeUserEntity QhqeUserEntity = new QhqeUserEntity(qhqeUserDetails.getUserId(),
					qhqeUserDetails.getFirstName(), qhqeUserDetails.getLastName(), qhqeUserDetails.getMidName(),
					qhqeUserDetails.getPhNum(), qhqeUserDetails.getEmail(), qhqeUserDetails.getQhqeId(),
					qhqeUserDetails.getQhqeName(), qhqeUserDetails.getQhqeType(), UserProvConstant.ACTIVE_USER_SW,
					qhqeUserDetails.getOperationBy(), null, LocalDateTime.now(), null);

			qhqeRepository.save(QhqeUserEntity);

			baseResponse.setStatus(Status.SUCCESS);
			baseResponse.setRespCode(HttpStatus.OK.value());

			return baseResponse;

		} catch (Exception e) {

			throw new UserProServiceException(message.get("general.exception"));
		}
	}

	@Override
	public BaseResponse updateUser(QhqeUserDetails qhqeUserDetails) {

		try {
			BaseResponse baseResponse = new BaseResponse();

			QhqeUserEntity QhqeUserEntity = getUser(qhqeUserDetails.getUserId());

			if (QhqeUserEntity == null) {
				return userNotExist(baseResponse);
			}

			if (!QhqeUserEntity.getActiverUser().equalsIgnoreCase(UserProvConstant.ACTIVE_USER_SW)) {

				baseResponse.setRespCode(HttpStatus.OK.value());
				baseResponse.setRespMessage(message.get("user.not.active"));
				baseResponse.setStatus(Status.FAIL);
				return baseResponse;
			}

			QhqeUserEntity.setFirstName(qhqeUserDetails.getFirstName());
			QhqeUserEntity.setLastName(qhqeUserDetails.getLastName());
			QhqeUserEntity.setMidName(qhqeUserDetails.getMidName());
			QhqeUserEntity.setPhNum(qhqeUserDetails.getPhNum());
			QhqeUserEntity.setEmail(qhqeUserDetails.getEmail());
			QhqeUserEntity.setQhqeId(qhqeUserDetails.getQhqeId());
			QhqeUserEntity.setQhqeName(qhqeUserDetails.getQhqeName());
			QhqeUserEntity.setQhqeType(qhqeUserDetails.getQhqeType());
			QhqeUserEntity.setUpdatedBy(qhqeUserDetails.getOperationBy());
			QhqeUserEntity.setUpdatedDate(LocalDateTime.now());

			qhqeRepository.save(QhqeUserEntity);

			baseResponse.setStatus(Status.SUCCESS);
			baseResponse.setRespCode(HttpStatus.OK.value());

			return baseResponse;

		} catch (Exception e) {

			throw new UserProServiceException(message.get("general.exception"));
		}

	}

	@Override
	public BaseResponse suspendUser(UserOperation user) {
		try {
			BaseResponse baseResponse = new BaseResponse();

			QhqeUserEntity QhqeUserEntity = getUser(user.getUserId());

			if (QhqeUserEntity == null) {
				return userNotExist(baseResponse);
			}

			if (!QhqeUserEntity.getActiverUser().equalsIgnoreCase(UserProvConstant.ACTIVE_USER_SW)) {

				baseResponse.setRespCode(UserProvConstant.BUSINESS_EXCEPTION);
				baseResponse.setRespMessage(message.get("user.suspended"));
				baseResponse.setStatus(Status.FAIL);
				return baseResponse;
			}

			QhqeUserEntity.setActiverUser(UserProvConstant.INACTIVE_USER_SW);
			QhqeUserEntity.setUpdatedDate(LocalDateTime.now());
			QhqeUserEntity.setUpdatedBy(user.getOperationBy());
			qhqeRepository.save(QhqeUserEntity);

			baseResponse.setStatus(Status.SUCCESS);
			baseResponse.setRespCode(HttpStatus.OK.value());

			return baseResponse;

		} catch (Exception e) {

			throw new UserProServiceException(message.get("general.exception"));
		}

	}

	@Override
	public BaseResponse restoreUser(UserOperation user) {
		try {
			BaseResponse baseResponse = new BaseResponse();

			QhqeUserEntity QhqeUserEntity = getUser(user.getUserId());

			if (QhqeUserEntity == null) {
				return userNotExist(baseResponse);
			}

			if (QhqeUserEntity.getActiverUser().equalsIgnoreCase(UserProvConstant.ACTIVE_USER_SW)) {

				baseResponse.setRespCode(UserProvConstant.BUSINESS_EXCEPTION);
				baseResponse.setRespMessage(message.get("user.is.active"));
				baseResponse.setStatus(Status.FAIL);
				return baseResponse;
			}

			QhqeUserEntity.setActiverUser(UserProvConstant.ACTIVE_USER_SW);
			QhqeUserEntity.setUpdatedDate(LocalDateTime.now());
			QhqeUserEntity.setUpdatedBy(user.getOperationBy());
			qhqeRepository.save(QhqeUserEntity);

			baseResponse.setStatus(Status.SUCCESS);
			baseResponse.setRespCode(HttpStatus.OK.value());

			return baseResponse;

		} catch (Exception e) {

			throw new UserProServiceException(message.get("general.exception"));
		}
	}

	@Override
	public BaseResponse<UserDetailWrapper> getUserDetail(String userId) {
		try {

			BaseResponse<UserDetailWrapper> baseResponse = new BaseResponse<UserDetailWrapper>();

			QhqeUserEntity QhqeUserEntity = getUser(userId);

			if (QhqeUserEntity == null) {
				baseResponse = userNotExistWithSuccess(baseResponse);
				return baseResponse;
			}

			UserDetailWrapper userDetailWrapper = qhqeUserTranslator.translate(QhqeUserEntity);

			baseResponse.setData(userDetailWrapper);
			baseResponse.setStatus(Status.SUCCESS);
			baseResponse.setRespCode(HttpStatus.OK.value());
			return baseResponse;

		} catch (Exception e) {

			throw new UserProServiceException(message.get("general.exception"));
		}

	}

	@Override
	public BaseResponse<List<UserDetailWrapper>> getQhqeDetail(String qhqeId) {
		try {

			BaseResponse<List<UserDetailWrapper>> baseResponse = new BaseResponse<List<UserDetailWrapper>>();

			List<QhqeUserEntity> QhqeUserEntities = qhqeRepository.getQhqeDetail(qhqeId);

			if (QhqeUserEntities == null || QhqeUserEntities.size() == 0) {
				baseResponse.setRespCode(HttpStatus.OK.value());
				baseResponse.setStatus(Status.SUCCESS);
				return baseResponse;
			}

			List<UserDetailWrapper> userDetailWrappers = qhqeUserTranslator.translate(QhqeUserEntities);

			baseResponse.setData(userDetailWrappers);
			baseResponse.setStatus(Status.SUCCESS);
			baseResponse.setRespCode(HttpStatus.OK.value());

			return baseResponse;

		} catch (Exception e) {

			throw new UserProServiceException(message.get("general.exception"));
		}
	}

	public boolean isUserExist(String userId) {
		return qhqeRepository.findById(userId).isPresent();
	}

	public QhqeUserEntity getUser(String userId) {

		Optional<QhqeUserEntity> QhqeUserEntity = qhqeRepository.findById(userId);
		if (QhqeUserEntity.isPresent())
			return QhqeUserEntity.get();
		else
			return null;
	}

	public BaseResponse userNotExist(BaseResponse baseResponse) {
		baseResponse.setRespCode(UserProvConstant.BUSINESS_EXCEPTION);
		baseResponse.setRespMessage(message.get("user.not.exist"));
		baseResponse.setStatus(Status.FAIL);
		return baseResponse;
	}

	public BaseResponse userNotExistWithSuccess(BaseResponse baseResponse) {
		baseResponse.setRespCode(HttpStatus.OK.value());
		baseResponse.setStatus(Status.SUCCESS);
		return baseResponse;
	}

	public BaseResponse userExist(BaseResponse baseResponse) {
		baseResponse.setRespCode(UserProvConstant.BUSINESS_EXCEPTION);
		baseResponse.setRespMessage(message.get("user.exist"));
		baseResponse.setStatus(Status.FAIL);
		return baseResponse;
	}

}
