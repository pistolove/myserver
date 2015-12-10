package com.lib.util;

import java.util.Properties;


public class ApplicationUtil {

	private static Properties props = new Properties();
	
	
	static {
		
		
	}
	
	
	public static String get(String path) {
		return props.getProperty(path);
	}	

}
