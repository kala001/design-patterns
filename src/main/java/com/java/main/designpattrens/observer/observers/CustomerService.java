package com.java.main.designpattrens.observer.observers;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;

import com.java.main.designpattrens.observer.Customer;
import com.java.main.designpattrens.observer.CustomerEvent;

public class CustomerService {
	
	public void createCustomer ( @Observes @Priority(10) @CustomerEvent(CustomerEvent.Type.ADD) Customer customer) {
		//create the  the customer
	}
	
	
	
	public void removeCustomer ( @ObservesAsync  @CustomerEvent(CustomerEvent.Type.REMOVE) Customer customer) {
		//create the  the customer
	}

}
