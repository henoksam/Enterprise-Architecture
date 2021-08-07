package edu.miu.cs.cs544.bank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

@Aspect
public class Logging {

	@Before("execution(* edu.miu.cs.cs544.bank.dao.*.*(..))")
	public void callMethod(JoinPoint jp) {
		System.out.println(jp.getSignature().getName() + " method is being called");
	}

	@Around("execution(* edu.miu.cs.cs544.bank.service.*.*(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Time to execute save= " + totaltime);

		return retVal;
	}

	@After("execution(* edu.miu.cs.cs544.bank.jms.JMSSender.sendJMSMessage (..)) && args(text)")
   public void sendMessage(String text) {
		System.out.println(text);
	}
	
	
}
