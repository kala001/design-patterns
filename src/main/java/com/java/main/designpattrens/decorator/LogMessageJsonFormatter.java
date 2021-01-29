package com.java.main.designpattrens.decorator;


import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;

import com.java.main.designpattrens.decorator.thirdpartylogger.LogMessage;

@Priority(20)
@Decorator
public abstract class LogMessageJsonFormatter implements LogMessage {

	@Any // as we want to inject decorator to all instance of Log message
	@Delegate // to identify this as the delegate
	@Inject
	@ComplexMessage
	private LogMessage logMessage;
	
	@Override
	public void printMessage() {
		String message = logMessage.getMessage();
		String jsonMessage = message;/*JsonbBuilder.create().toJson(message);*/
		logMessage.setMessage(jsonMessage);
	}

}
