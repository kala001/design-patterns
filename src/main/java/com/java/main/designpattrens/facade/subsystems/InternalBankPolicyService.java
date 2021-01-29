package com.java.main.designpattrens.facade.subsystems;

import javax.ejb.Stateless;

import com.java.main.designpattrens.facade.Customer;

@Stateless
public class InternalBankPolicyService {
	
	public boolean checkComplaince(Customer customer) {
		return true;
	}


}
