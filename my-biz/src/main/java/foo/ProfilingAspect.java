package foo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProfilingAspect {

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) {

		System.out.println("执行前");
		Object retVal = null;
		try {
			retVal = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("执行后");
		return retVal;

	}

	@Pointcut("execution(public * foo..*.*(..))")
	public void pointCut() {

	}

}
