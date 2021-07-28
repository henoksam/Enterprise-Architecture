package cs544.exercise12_1.bank.logging;

import org.springframework.stereotype.Service;

@Service
public class Logger implements ILogger{
	
	

	public Logger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

}
