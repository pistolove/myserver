package myserver.api.modules.user.dto;

import myserver.api.modules.dto.BaseDto;

public class UserDto extends BaseDto {
	private static final long serialVersionUID = -2177925934515034120L;

	private String uid;//用户id

	private String uname;//用户名称

	private Long phoneNumber;//手机号

	private String uinfo;//用户说明

	private String email;//邮箱
	
	private String secrect;//密码

	/**
	 * 测试测试
	 */
	public static void getName() {
		
	}
	
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
	
	
	public static class Child {
		private Integer age1;
		
		private String name1;
		
		private String email1;
	}
}
