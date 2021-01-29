package com.java.main.designpattrens.observer.observers;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

import com.java.main.designpattrens.observer.Customer;
import com.java.main.designpattrens.observer.CustomerEvent;

public class AuthenticationService {
	
	public void createAuthenticationCredentials( @Observes @ Priority(100) @CustomerEvent(CustomerEvent.Type.ADD)Customer customer) {
		//create the authentication cred for the customer
	}

}
