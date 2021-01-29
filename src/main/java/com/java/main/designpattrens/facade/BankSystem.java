package com.java.main.designpattrens.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.java.main.designpattrens.facade.subsystems.CreditRatingService;
import com.java.main.designpattrens.facade.subsystems.InternalBankPolicyService;
import com.java.main.designpattrens.facade.subsystems.RepaymentService;
import com.java.main.designpattrens.facade.subsystems.RepaymentpayabilityService;
import com.java.main.designpattrens.facade.subsystems.TransferService;

@Stateless
public class BankSystem {
	
	@EJB
	private CreditRatingService creditRatingService;
	
	@EJB
	private RepaymentpayabilityService rpservice;
	
	@EJB
	private InternalBankPolicyService ibps;
	
	@EJB
	private TransferService ts;
	
	@EJB
	private RepaymentService rps;

	public boolean processApplication(Customer customer, Double principle, Double income, Integer months)  {
		boolean passes = creditRatingService.checkCustomerrating(customer);
		
		if (!passes) {
			return false;
		}
		 boolean affordable = rpservice.calculatePayability(principle, income ,months);
		 if (!affordable) {
			 return false;
		 }
		 boolean complaint = ibps.checkComplaince(customer) ;
		 if (!complaint) {
			 return false;
		 }
		 
		 ts.makeTransfer(principle, customer);
		 rps.setUpPaymetScedule(customer, principle ,months);
		
		return true;
	}	
}
