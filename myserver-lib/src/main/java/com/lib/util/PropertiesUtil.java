package com.lib.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil {

	private static final Logger log = LoggerFactory.getLogger(PropertiesUtil.class);
	
	private static PropertiesUtil propertiesUtil;
	
	public synchronized static PropertiesUtil getInstance() {
		if(propertiesUtil == null) {
			synchronized (PropertiesUtil.class) {
				if(propertiesUtil == null) {
					propertiesUtil = new PropertiesUtil();
				}
			}
		}
		return propertiesUtil;
	}

	/**
	 * 
	 * @param path
	 * @param isFilePath==false时，通过classPath;
 	 * @return
	 */
	public Properties getPropByFilePath2ClassPath(String path, Boolean isFilePath) {
		Properties properties = new Properties();
		InputStream stream = null;
		
		try {
			if(!isFilePath) {
				stream = getClass().getResourceAsStream(path);
			} else {
				stream = new FileInputStream(path);
			}
			properties.load(stream);
			PropertyConfigurator.configure(properties);
		} catch (Exception e) {
			log.error("get properties error");
		}
		
		return properties;
	}
}
