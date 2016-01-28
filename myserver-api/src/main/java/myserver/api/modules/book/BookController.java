package myserver.api.modules.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myserver.api.modules.BaseController;
import myserver.api.modules.book.dto.BookDto;
import myserver.api.modules.response.Response;

@Controller
public class BookController extends BaseController{

	@RequestMapping("/book/get/id")
	public Response<BookDto> getBookById(@RequestParam(value="id") String id){
		return this.facadeService.getBookService().getBookById(id);
	}
}
