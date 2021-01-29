package com.java.main.designpattrens.facade.subsystems;

import javax.ejb.Stateless;

import com.java.main.designpattrens.facade.Customer;

@Stateless
public class CreditRatingService {
	
	
	public boolean checkCustomerrating(Customer customer) {
		return true;
	}

}
