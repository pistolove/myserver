package myserver.api.modules.book;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lib.mysql.book.table.BookMySqlTable;

import myserver.api.modules.BaseService;
import myserver.api.modules.book.dto.BookDto;
import myserver.api.modules.response.Response;

@Service
public class BookService extends BaseService{

	private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();
	static {
		OBJECTMAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public Response<BookDto> getBookById(String id) {
		Response<BookDto> response = null;
		if(StringUtils.isNotBlank(id)) {
			response = new Response<BookDto>();
			String key = BookConstant.BOOK_CACHE + id;
			String cache = this.cacheTemplate.get(key);
			if(StringUtils.isNotBlank(cache)) {
				try {
					response = OBJECTMAPPER.readValue(cache, new TypeReference<BookDto>(){
					});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				BookMySqlTable table = this.facadeMySqlDao.getBookMySqlDao().getBookById(id);
				BookDto bookDto = new BookDto();
				bookDto.setBid(table.getBid());
				bookDto.setBname(table.getBname());
				bookDto.setCategory(table.getCategory());
				bookDto.setDesc(table.getDesc());
				bookDto.setPages(table.getPages());
				bookDto.setPrice(table.getPrice());
				bookDto.setPublication(table.getPublication());
				bookDto.setPubtime(table.getPubtime());
				response.setData(bookDto);
				
				int code = this.cacheTemplate.set(key, bookDto);
				if(code == 0){
					System.err.println("ok");
				}else{
					System.err.println("error");
				}
			}
		}
		return response;
	}

}
