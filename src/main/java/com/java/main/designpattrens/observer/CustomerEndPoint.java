package com.java.main.designpattrens.observer;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ForkJoinPool;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.NotificationOptions;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/customers")
public class CustomerEndPoint {
	
	@Inject @CustomerEvent(CustomerEvent.Type.ADD)
	private Event<Customer> customerAddEvent;
	
	@Inject@CustomerEvent(CustomerEvent.Type.REMOVE)
	private Event<Customer> customerRemoveEvent;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void newCustomer(Customer customer) {
		customerAddEvent.fire(customer);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeCustomer(Customer customer) {
		CompletionStage<Customer> stage = customerRemoveEvent.fireAsync(customer /*,NotificationOptions.ofExecutor(new ForkJoinPool(10))*/);
		/*stage.handle((customer_event, Throwable_ex) -> { 
				for (Throwable t : ex.getSuppressed()) {
					//log exceptions	
				}
				return event;
		});	*/
	}

}
