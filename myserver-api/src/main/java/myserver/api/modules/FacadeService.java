package myserver.api.modules;

import javax.annotation.Resource;

import myserver.api.modules.book.BookService;
import myserver.api.modules.comment.CommentService;
import myserver.api.modules.user.UserService;

import org.springframework.stereotype.Component;

@Component
public class FacadeService {

	@Resource
	protected UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource
	protected BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
