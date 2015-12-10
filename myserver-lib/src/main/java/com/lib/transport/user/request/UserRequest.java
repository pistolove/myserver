package com.lib.transport.user.request;

import com.lib.constant.ApplicationConstant;
import com.lib.transport.BaseRequest;
import com.lib.util.ApplicationUtil;

public class UserRequest implements BaseRequest {
	private static final String RET_URL = ApplicationUtil.get(ApplicationConstant.USER_REQUEST_URL);
	
	
	private String uid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public UserRequest(String uid) {
	}

	public String buildPath() {
		return null;
	}

	public String Sign() {
		return null;
	}

}
