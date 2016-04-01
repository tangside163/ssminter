package org.tangsi.schedule;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PrintJob implements Job
{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String name = (String) jobDataMap.get("name");
		System.out.println("print任务执行， 名称为:" + name);

	}

}
