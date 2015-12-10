package com.lib.transport;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lib.transport.comment.CommentTpDao;
import com.lib.transport.user.UserTpDao;

@Component
public class FacadeTpDao {

	@Resource
	protected UserTpDao userTpDao;

	@Resource
	protected CommentTpDao commentTpDao;


	public UserTpDao getUserTpDao() {
		return userTpDao;
	}

	public void setUserTpDao(UserTpDao userTpDao) {
		this.userTpDao = userTpDao;
	}

	public CommentTpDao getCommentTpDao() {
		return commentTpDao;
	}

	public void setCommentTpDao(CommentTpDao commentTpDao) {
		this.commentTpDao = commentTpDao;
	}

}
