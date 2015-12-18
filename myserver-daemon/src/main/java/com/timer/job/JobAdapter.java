package com.timer.job;


import java.lang.reflect.Method;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定时任务代理
 */
public class JobAdapter implements Job {

	private Object object;

	private String methodName;

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		try {
			Method method = this.object.getClass().getMethod(this.methodName,
					new Class[0]);

			method.invoke(this.object, new Object[0]);
		} catch (Exception e) {
			throw new JobExecutionException(e.getMessage(), e);
		}
	}
}
