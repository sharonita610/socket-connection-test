package org.socket.connection.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class InOutLogAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(InOutLogAspect.class);

	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void loggingPointcut() {
	}

	@Around("loggingPointcut()")
	public Object logginInOutBound(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("METHOD RUN : {}", joinPoint.getSignature().toString());
		StopWatch stopWatch = new StopWatch("Stop Watch");
		stopWatch.start();
		Object result = joinPoint.proceed();
		stopWatch.stop();
		LOGGER.info("METHOD TIME COMPLETED : {}", stopWatch.getTotalTimeMillis());
		return result;
	}
}
