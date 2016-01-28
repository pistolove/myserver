package myserver.api.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import myserver.api.modules.user.dto.UserDto;

public class TestFiled {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException {
//		UserDto userDto = new UserDto();
//		Field[] fields = userDto.getClass().getDeclaredFields();
//		for (int i = 0; i < fields.length; i++) {
//			System.out.println("成员变量" + i + "类型 : " + fields[i].getType().getName());
//			System.out.println("成员变量" + i + "变量名: " + fields[i].getName());
//		}
//
//		Method m = userDto.getClass().getMethod("getName");
//		System.err.println(m);

		Map<UserDto, Integer> maps = new HashMap<UserDto, Integer>();
		
		UserDto d1 = new UserDto();
		
		maps.put(d1, 100);
		
		System.err.println(maps.get(d1));
		
		d1.setUname("abcd11111");
		d1.setUid("1234");
		
		System.err.println(maps.get(d1));
	
		
	}
	
	
	
}
