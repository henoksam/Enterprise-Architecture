package cs544.exercise12_1.bank.jms;

import org.springframework.stereotype.Service;

@Service
public class JMSSender implements IJMSSender{
	
	
	
	public JMSSender() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
