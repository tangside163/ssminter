/**
 * 
 */
package org.tangsi.common.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import com.alibaba.fastjson.JSON;

/**
 * @author numb
 *
 */
@Aspect
public class LogAspect {

	private static final Logger logger = LogManager.getLogger(LogAspect.class);

	public Object invoke(ProceedingJoinPoint joinPoint) {
		StringBuilder sb = new StringBuilder();
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length > 0) {
			for (Object arg : args) {
				sb.append(JSON.toJSON(arg)).append(",");
			}
		}
		// 参数列表
		String params = sb.substring(0, sb.length() - 1);
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		logger.info(className + "." + methodName + "()执行前, 传入参数为：" + params);
		Object returnValue = null;
		try {
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
			logger.error("LogAspect 前后拦截发生错误", e);
		} finally {
			logger.info(className + "." + methodName + "()执行后");
			return returnValue;
		}
	}

}
