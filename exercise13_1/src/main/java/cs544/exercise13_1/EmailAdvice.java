package cs544.exercise13_1;

import java.time.LocalDate;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class EmailAdvice{
	
	//static Logger log=Logger.getLogger(EmailAdvice.class.getName());
	
	
	@After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email,message)")
	public void emailLog(JoinPoint joinpoint, String email, String message) {
		
		//a) System.out.println(LocalDate.now().toString()+ " method= sendMail");
		
		//b)System.out.println(LocalDate.now().toString()+ " method= sendMail" + " address= "+ email 
			//	+"\nmessage= "+message);
		EmailSender es=(EmailSender) joinpoint.getTarget();
		
		
		System.out.println(LocalDate.now().toString()+ " method= sendMail" + " address= "+ email 
			+"\nmessage= "+message +"\noutgoing mail server = " + es.getOutgoingMailServer() );
		
		
	}
	
	

}
