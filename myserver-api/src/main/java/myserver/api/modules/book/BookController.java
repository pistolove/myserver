package myserver.api.modules.book;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lib.mysql.book.BookMySqlTable;

import myserver.api.modules.BaseController;
import myserver.api.modules.book.dto.BookDto;
import myserver.api.modules.dto.ValueDto;
import myserver.api.modules.response.Response;

@Controller
public class BookController extends BaseController {

	@RequestMapping("/book/get/id")
	public Response<BookDto> getBookById(@RequestParam(value = "id") String id) throws Exception {
		return this.facadeService.getBookService().getBookById(id);
	}

	@RequestMapping("/book/delete/id")
	public Response<ValueDto<Boolean>> deleteBookById(@RequestParam(value = "id") String id) throws Exception {
		return this.facadeService.getBookService().deleteBookById(id);
	}

	@RequestMapping("/book/update/id")
	public Response<ValueDto<Boolean>> updateBookById(@RequestParam(value="bname") String bname,
			@RequestParam(value="category") String category,
			@RequestParam(value="desc") String desc,
			@RequestParam(value="price") String price,
			@RequestParam(value="publication") String publication,
			@RequestParam(value="pubtime") String pubtime,
			@RequestParam(value="pages") String pages,
			@RequestParam(value="bid") String bid) throws Exception {
		BookMySqlTable table = new BookMySqlTable();
		table.setBid(Integer.parseInt(bid));
		table.setBname(bname);
		table.setCategory(category);
		table.setDesc(desc);
		table.setPages(Integer.parseInt(pages));
		table.setPrice(new BigDecimal(price));
		table.setPublication(publication);
		table.setPubtime(pubtime);
		return this.facadeService.getBookService().updateBookById(table);
	}
}
