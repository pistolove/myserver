package myserver.api.modules.user.dto;

import myserver.api.modules.dto.BaseDto;

public class UserDto extends BaseDto {
	private static final long serialVersionUID = -2177925934515034120L;

	private String uid;

	private String uname;

	private Long phoneNumber;

	private String uinfo;

	private String email;
	private String secrect;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUinfo() {
		return uinfo;
	}

	public void setUinfo(String uinfo) {
		this.uinfo = uinfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecrect() {
		return secrect;
	}

	public void setSecrect(String secrect) {
		this.secrect = secrect;
	}
}
