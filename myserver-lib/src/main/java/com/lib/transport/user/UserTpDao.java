package com.lib.transport.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lib.transport.BaseTpDao;
import com.lib.transport.user.request.UserRequest;
import com.lib.transport.user.response.UserResponse;

public class UserTpDao extends BaseTpDao{
	private static final Logger log = LoggerFactory.getLogger(UserTpDao.class);
	
	public UserResponse getUserInfoById(UserRequest request) {
		UserResponse userResponse = null;
		String logPrefix = "getUserInfoById_" + request.getUid();
		try {
			userResponse = this.httpClientTemplate.getForObject(request, UserResponse.class);
		} catch (Exception e) {
			log.error(logPrefix, e);
		}
		return userResponse;
	}
	
}


