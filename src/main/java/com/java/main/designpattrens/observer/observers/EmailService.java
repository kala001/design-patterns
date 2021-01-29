package com.java.main.designpattrens.observer.observers;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

import com.java.main.designpattrens.observer.Customer;
import com.java.main.designpattrens.observer.CustomerEvent;

public class EmailService {
	
	public void SendWelcomeEmail ( @Observes @ Priority(1000) @CustomerEvent(CustomerEvent.Type.ADD) Customer customer) {
		//send welcome email to customer
	}

}
