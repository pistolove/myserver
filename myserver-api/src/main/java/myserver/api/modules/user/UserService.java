package myserver.api.modules.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.lib.transport.user.request.UserRequest;
import com.lib.transport.user.response.UserResponse;

import myserver.api.modules.BaseService;
import myserver.api.modules.dto.BaseDto;
import myserver.api.modules.dto.SingleDto;
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
			UserRequest request = new UserRequest(uid);
			UserResponse userResponse = this.facadeTpDao.getUserTpDao().getUserInfoById(request);
			if(userResponse != null) {
				UserDto dto = new UserDto();
				dto.setUid(userResponse.getUserId());
				dto.setEmail(userResponse.getUserEmail());
				dto.setPhoneNumber(userResponse.getTelePhone());
				dto.setUinfo(userResponse.getUserInfo());
				dto.setUname(userResponse.getUserName());
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

	public SingleDto<Boolean> deleteUser(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

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

}
