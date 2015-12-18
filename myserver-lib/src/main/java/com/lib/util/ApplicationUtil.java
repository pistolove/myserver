package com.lib.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationUtil {

	private static Properties props = new Properties();
	private static final String FILEPATH;
	
	static {
		String path = System.getProperty("conf.dir");
		if(!path.endsWith("/")) {
		    path = path + "/";
		}
		path = path + "application.properties";
		FILEPATH = path;
		loadClassPath();
	}
	
	
	public static String get(String path) {
		return props.getProperty(path);
	}

	
	public static final Integer getInt(String k) {
	    String obj =  props.getProperty(k);
	    Integer value = null;
	    if(obj != null) {
	        try {
                value = Integer.parseInt(obj);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
	    }
	    return value;
	}

	public static final Boolean getBoo(String k) {
	    String obj = props.getProperty(k);
	    Boolean b = null;
	    if(obj != null) {
	        try {
                b = Boolean.parseBoolean(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
	    }
	    return b;
	}
	
    private static void loadClassPath() {
        Properties properties = null;
        InputStream stream = null;
        try {
            properties = new Properties();
            stream = new FileInputStream(FILEPATH);
            properties.load(stream);
            props = properties;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }	
}
