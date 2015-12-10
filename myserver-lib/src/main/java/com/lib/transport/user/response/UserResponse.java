package com.lib.transport.user.response;

import com.lib.transport.BaseResponse;

public class UserResponse extends BaseResponse {

	private String userId;

	private String userName;

	private Long telePhone;

	private String userInfo;

	private String userEmail;

	private String userKey;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(Long telePhone) {
		this.telePhone = telePhone;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

}
