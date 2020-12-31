package com.practise.api.translator;

import org.springframework.stereotype.Component;

import com.practise.api.common.AbstractModelTranslator;
import com.practise.api.jpa.entity.QhqeUserEntity;
import com.practise.api.model.QhqeAudit;
import com.practise.api.model.QhqeUserDetails;
import com.practise.api.model.UserDetailWrapper;

@Component
public class QhqeUserTranslator extends AbstractModelTranslator<QhqeUserEntity, UserDetailWrapper> {

	@Override
	public UserDetailWrapper translate(QhqeUserEntity original) {

		UserDetailWrapper userDetailWrapper = new UserDetailWrapper();

		if (original != null) {

			QhqeUserDetails qhqeUserDetails = new QhqeUserDetails(original.getUserId(), original.getFirstName(),
					original.getLastName(), original.getMidName(), original.getPhNum(), original.getEmail(),
					original.getQhqeId(), original.getQhqeName(), original.getQhqeType());

			QhqeAudit qhqeAudit = new QhqeAudit(original.getCreatedBy(), original.getUpdatedBy(),
					original.getCreatedDate(), original.getUpdatedDate(), original.getActiverUser());

			userDetailWrapper.setQhqeUserDetails(qhqeUserDetails);
			userDetailWrapper.setQhqeAudit(qhqeAudit);

			return userDetailWrapper;

		}

		return null;
	}

}
