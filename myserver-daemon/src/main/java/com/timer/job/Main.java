package com.timer.job;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

import org.apache.log4j.PropertyConfigurator;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    static {
        setJvmParams();
        initLog4jCfg();
    }

    
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
	public static void main(String[] args) throws FileNotFoundException {
		String confDir = System.getProperty("user.dir") + "/src/main/resources/conf/";
		String die = System.getProperty("conf.dir");
		PropertyConfigurator.configure(new FileInputStream(die
				+ "/log4j.properties"));

		/*
		 * 解析配置文件
		 */
		LinkedList<String> tasks = new LinkedList<String>();
		BufferedReader br = null;
		try {
			String file = confDir + "timer.properties";
			br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			while (line != null) {
				tasks.add(line);

				line = br.readLine();
			}
		} catch (Exception e) {
			System.err.println("error");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
				System.err.println("error");
			}
		}

		if (tasks.size() > 0) {
			try {
				/*
				 * 加载定时任务
				 */
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Users/liqqc/Desktop/time-quartz.xml");

				/*
				 * 启动定时器
				 */
				SchedulerFactory schedulerFactory = new StdSchedulerFactory();
				Scheduler scheduler = schedulerFactory.getScheduler();
				scheduler.start();

				/*
				 * 启动定时任务
				 */
				for (String task : tasks) {
					String[] arr = task.split(":");
					String beanName = arr[0];
					String methodName = arr[1];
					String cron = arr[2];

					JobDataMap jobDataMap = new JobDataMap();
					jobDataMap.put("object",
							applicationContext.getBean(beanName));
					jobDataMap.put("methodName", methodName);
					JobDetail jobDetail = JobBuilder.newJob(JobAdapter.class)
							.withIdentity(beanName, methodName)
							.usingJobData(jobDataMap).build();

					Trigger trigger = TriggerBuilder
							.newTrigger()
							.withIdentity(beanName, methodName)
							.withSchedule(
									CronScheduleBuilder.cronSchedule(cron))
							.build();

					scheduler.scheduleJob(jobDetail, trigger);
				}
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			}
		} else {
		}
	}

	 public static void initLog4jCfg() {
	        try {
	            String dir = System.getProperty("conf.dir");
	            if (dir == null || "".equals(dir)) {
	                System.exit(-1);
	            }
	            if (!dir.endsWith("/")) {
	                dir += "/";
	            }
	            String log4jPath = dir + "log4j.properties";
	            System.setProperty("log4j.configuration", log4jPath);
	            PropertyConfigurator.configure(new FileInputStream(log4jPath));

	        } catch (Exception e) {
	            System.exit(-1);
	        }
	    }

	public static void setJvmParams() {
		String osName = System.getProperty("os.name");
		if (osName.equalsIgnoreCase("Linux")) {
		} else {
			System.setProperty("conf.dir", "/Users/liqqc/conf");
		}
	}

}
