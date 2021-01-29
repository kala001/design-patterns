package com.java.main.designpattrens.facade.subsystems;

import javax.ejb.Stateless;

@Stateless
public class RepaymentpayabilityService {
	
	public boolean calculatePayability(Double principle, Double income, Integer months) {
		return true;
	}

}
