package com.java.main.designpattrens.decorator;

import java.time.LocalDate;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import com.java.main.designpattrens.decorator.thirdpartylogger.LogMessage;

@Priority(10)
@Decorator // to mark this calss as decorator
public abstract class LogMessageFormatter implements LogMessage {

	@Any // as we want to inject decorator to all instance of Log message
	@Delegate // to identify this as the delegate
	@Inject
	private LogMessage logMessage;
	
	@Override
	public void printMessage() {
		String message = logMessage.getMessage();
		message = LocalDate.now().toString().concat(message);
		logMessage.setMessage(message);
	}


}
