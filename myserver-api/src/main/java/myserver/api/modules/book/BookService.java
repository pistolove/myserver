package myserver.api.modules.book;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lib.memory.Memory;
import com.lib.mysql.book.BookMySqlTable;
import com.lib.util.ApplicationUtil;

import myserver.api.modules.BaseService;
import myserver.api.modules.book.dto.BookDto;
import myserver.api.modules.dto.ValueDto;
import myserver.api.modules.response.Response;

@Service(value = "bookService")
public class BookService extends BaseService {

	private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

	static {
		OBJECTMAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Resource(name = "userMemoryTemplete")
	protected Memory mem;

	public Response<BookDto> getBookById(String id) throws Exception {
		Response<BookDto> response = null;
		BookDto bookDto = null;
		if (StringUtils.isNotBlank(id)) {
			response = new Response<BookDto>();
			String key = BookConstant.BOOK_CACHE + id;

			if (this.mem.get(key) != null) {
				bookDto = (BookDto) this.mem.get(key);
				response.setData(bookDto);
			} else {
				if (this.cacheTemplate.get(key) != null) {
					bookDto = (BookDto) this.cacheTemplate.get(key);
					this.mem.set(key, bookDto);
					response.setData(bookDto);
				} else {
					BookMySqlTable table = this.facadeMySqlDao.getBookMySqlDao().getBookById(id);
					bookDto = new BookDto();
					bookDto.setBid(table.getBid());
					bookDto.setBname(table.getBname());
					bookDto.setCategory(table.getCategory());
					bookDto.setDesc(table.getDesc());
					bookDto.setPages(table.getPages());
					bookDto.setPrice(table.getPrice());
					bookDto.setPublication(table.getPublication());
					bookDto.setPubtime(table.getPubtime());
					response.setData(bookDto);

					this.mem.set(key, bookDto);
					int code = this.cacheTemplate.set(key, bookDto);
					if (code == 0) {
						System.err.println("ok");
					} else {
						System.err.println("error");
					}
				}
			}
		}
		return response;
	}

	public Response<ValueDto<Boolean>> deleteBookById(String id) {
		Response<ValueDto<Boolean>> response = new Response<ValueDto<Boolean>>();
		String errorCode = null;
		String errorMsg = null;
		if (StringUtils.isNotBlank(id)) {
			Integer v = this.facadeMySqlDao.getBookMySqlDao().deleteBookById(id);
			if (v != null && v.intValue() == 1) {
				ValueDto<Boolean> value = new ValueDto<Boolean>();
				value.setSingle(true);
				response.setData(value);
			} else {
				ValueDto<Boolean> value = new ValueDto<Boolean>();
				value.setSingle(false);
				response.setData(value);
			}
		} else {
			errorCode = BookConstant.DELETE_ERROR_CODE;
			errorMsg = ApplicationUtil.get(BookConstant.DELETE_ERROR_CODE);
			response.setErrorCode(errorCode);
			response.setErrorMessage(errorMsg);
		}
		return response;
	}

	public Response<ValueDto<Boolean>> updateBookById(BookMySqlTable bookMysqlTable) {
		Response<ValueDto<Boolean>> response = new Response<ValueDto<Boolean>>();
		String errorCode = null;
		String errorMsg = null;
		if (bookMysqlTable != null && StringUtils.isNotBlank(bookMysqlTable.getBid().toString())) {
			Integer v = this.facadeMySqlDao.getBookMySqlDao().updateBookById(bookMysqlTable);
			if (v != null) {
				ValueDto<Boolean> result = null;
				if(v.intValue() == 1) {
					result = new ValueDto<Boolean>();
					result.setSingle(true);
				}else {
					result = new ValueDto<Boolean>();
					result.setSingle(false);
				}
				response.setData(result);
			} else{
				errorCode = BookConstant.UPDATE_VALUE_NULL_CODE;
				errorMsg = ApplicationUtil.get(BookConstant.UPDATE_ERROR_CODE);
				response.setErrorCode(errorCode);
				response.setErrorMessage(errorMsg);
			}
		} else {
			errorCode = BookConstant.UPDATE_ERROR_CODE;
			errorMsg = ApplicationUtil.get(BookConstant.UPDATE_ERROR_CODE);
			response.setErrorCode(errorCode);
			response.setErrorMessage(errorMsg);
		}
		return response;
	}

}
