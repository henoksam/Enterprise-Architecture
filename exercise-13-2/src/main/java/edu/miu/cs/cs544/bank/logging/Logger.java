package edu.miu.cs.cs544.bank.logging;

import org.aspectj.lang.annotation.Aspect;

public class Logger implements ILogger {
	public Logger() {
	}

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);
	}
}
