package myserver.api.modules.user;

import myserver.api.modules.BaseController;
import myserver.api.modules.dto.BaseDto;
import myserver.api.modules.dto.ValueDto;
import myserver.api.modules.response.Response;
import myserver.api.modules.user.dto.UserDto;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController extends BaseController {

	@RequestMapping("/user/info/get")
	public Response<BaseDto> getUserInfo(@RequestParam(value = "uid") String uid) {
		return this.facadeService.getUserService().getUserInfo(uid);
	}

	@RequestMapping("/user/info/delete")
	public ValueDto<Boolean> deleteUser(@RequestParam(value = "uid") String uid) {
		return this.facadeService.getUserService().deleteUser(uid);
	}

	@RequestMapping("/user/info/update")
	public Response<BaseDto> updateUserInfo(
			@RequestParam(value = "uid") String uid,
			@RequestParam(value = "uname") String uname,
			@RequestParam(value = "uinfo", required = false) String uinfo,
			@RequestParam(value = "phonenumber", required = false) Long phonenumber,
			@RequestParam(value = "email") String email) {
		return this.facadeService.getUserService().updateUserInfo(uid, uname,
				uinfo, phonenumber, email);
	}

	@RequestMapping("/user/info/register")
	public Response<BaseDto> registerUser(
			@RequestParam(value = "uname") String uname,
			@RequestParam(value = "uinfo", required = false) String uinfo,
			@RequestParam(value = "phonenumber", required = false) Long phonenumber,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "secret") String secret) {
		return this.facadeService.getUserService().registerUser(uname,secret, 
				uinfo, phonenumber, email);
	}
	
	@RequestMapping("/user/info/all")
	public Response<Set<UserDto>> getAllUser(Integer type) {
		return this.facadeService.getUserService().getAllUser(type);
	}
}
