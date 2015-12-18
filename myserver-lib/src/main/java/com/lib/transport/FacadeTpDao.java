package com.lib.transport;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.lib.transport.user.UserTpDao;

@Component
public class FacadeTpDao {

	@Resource(name = "UserTpDao")
	protected UserTpDao userTpDao;


	public UserTpDao getUserTpDao() {
		return userTpDao;
	}

	public void setUserTpDao(UserTpDao userTpDao) {
		this.userTpDao = userTpDao;
	}

}
