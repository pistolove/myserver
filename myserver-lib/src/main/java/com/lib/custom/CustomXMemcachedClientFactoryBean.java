package com.lib.custom;


import java.util.ArrayList;
import java.util.List;

import net.rubyeye.xmemcached.utils.XMemcachedClientFactoryBean;

/**
 * 自定义XMemcachedClientFactoryBean
 */
public class CustomXMemcachedClientFactoryBean extends
		XMemcachedClientFactoryBean {

	/**
	 * 支持字符串方式配置
	 * 
	 * @param weights1
	 */
	public void setWeights1(String weights1) {
		String[] list = weights1.split(" ");

		List<Integer> weights = new ArrayList<Integer>();
		for (String item : list) {
			weights.add(Integer.valueOf(item));
		}

		this.setWeights(weights);
	}
}
