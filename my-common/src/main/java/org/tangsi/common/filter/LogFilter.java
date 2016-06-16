package org.tangsi.common.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Project my-common
 * @Description:
 * @Company youku
 * @Create 2016年6月16日上午10:07:19
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

public class LogFilter implements Filter
{

	private static final Logger bizLogger = LogManager.getLogger("org.apache.log4j.biz");

	private static final Logger accessLogger = LogManager.getLogger("org.apache.log4j.access");

	@Override
	public void destroy()
	{
		bizLogger.info("系统开始关闭");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		String accessInfo = this.getAccessInfo(req);
		accessLogger.info(accessInfo);
		chain.doFilter(request, response);

	}

	/**
	 * 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * 
	 * @param req
	 * @return
	 */
	private String getAccessInfo(HttpServletRequest request)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(request.getRequestURI());
		sb.append(" params:");
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements())
		{
			String paramName = enumeration.nextElement();
			String paramValue = request.getParameter(paramName);
			sb.append(paramName).append("=").append(paramValue);
			if (enumeration.hasMoreElements())
			{
				sb.append("&");
			}
		}

		sb.append(" User-Agent:").append(request.getHeader("user-agent"));
		sb.append(" sessionId:").append(request.getSession().getId());
		return sb.toString();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		bizLogger.info("系统开始启动");
	}

}
