package com.java.main.designpattrens.decorator;

import com.java.main.designpattrens.decorator.thirdpartylogger.LogMessage;

@ComplexMessage
public class SystemMessage implements LogMessage {

	@Override
	public void printMessage() {
		
	}

	@Override
	public String getMessage() {
		return null;
	}

	@Override
	public Void setMessage(String message) {
		return null;
	}

}
