package myserver.api.modules.user;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.lib.mysql.user.UserInfoMySqlTable;

import myserver.api.modules.BaseService;
import myserver.api.modules.dto.BaseDto;
import myserver.api.modules.dto.ValueDto;
import myserver.api.modules.response.Response;
import myserver.api.modules.user.dto.UserDto;
import myserver.api.util.MessageUtils;

@Service(value = "userService")
public class UserService extends BaseService{

	public Response<BaseDto> getUserInfo(String uid) {
		Response<BaseDto> response = new Response<BaseDto>();
		String errorCode = null;
		String errorMessage = null;
		if(StringUtils.isNotBlank(uid)) {
			UserInfoMySqlTable userInfo = this.facadeMySqlDao.getUserMysqlDao().getUseInfoById(uid);
			if(userInfo != null) {
				UserDto dto = new UserDto();
				dto.setUid(userInfo.getUserId());
				dto.setEmail(userInfo.getEmail());
				dto.setPhoneNumber(userInfo.getTelePhone());
				dto.setUinfo(userInfo.getUserInfo());
				dto.setUname(userInfo.getUserName());
				response.setData(dto);
			}else {
				errorCode = UserConstant.USER_INFO_GET_ERROR;
			}
		} else {
			errorCode = UserConstant.USER_ID_NULL;
		}
		
		if(errorCode !=null) {
			errorMessage = MessageUtils.getMessage(errorCode);
			response.setErrorCode(errorCode);
			response.setErrorMessage(errorMessage);
		}
		
		return response;
	}

	public ValueDto<Boolean> deleteUser(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询id是否存在不存在则不管
	 * @param uid
	 * @param uname
	 * @param uinfo
	 * @param phonenumber
	 * @param email
	 * @return
	 */
	public Response<BaseDto> updateUserInfo(String uid, String uname,
			String uinfo, Long phonenumber, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<BaseDto> registerUser(String uname, String secret,
			String uinfo, Long phonenumber, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<Set<UserDto>> getAllUser(Integer type) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
