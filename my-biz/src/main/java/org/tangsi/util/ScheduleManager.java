package org.tangsi.util;

import java.util.Map;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年4月1日下午5:42:32
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

public class ScheduleManager
{

	private static ScheduleManager instance = new ScheduleManager();

	private SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();

	private ScheduleManager()
	{
	}

	public static ScheduleManager getInstance()
	{
		return instance;
	}

	public void addOrUpdateJob(String jobName, String jobGroupName, String cron, Class<? extends Job> jobClazz,
			Map<String, String> jobDataMap)
	{
		Scheduler scheduler = schedulerFactory.getScheduler();
		TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);

		try
		{
			Trigger trigger = scheduler.getTrigger(triggerKey);
			if (trigger == null) // 没有任务则创建
			{
				JobDetail jobDetail = JobBuilder.newJob(jobClazz).withIdentity(jobName, jobGroupName).build();
				jobDetail.getJobDataMap().putAll(jobDataMap);
				CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(new CronExpression(cron));
				trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(builder).build();
				scheduler.scheduleJob(trigger);
			} else // 更新任务
			{
				CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(new CronExpression(cron));
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule((ScheduleBuilder) builder).build();
				scheduler.rescheduleJob(triggerKey, trigger);
			}
		} catch (Exception e)
		{
			throw new RuntimeException("添加或者更新调度任务发生错误");
		}

	}
}
