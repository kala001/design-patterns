package com.java.main.designpattrens.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@DependsOn("configuration")
@Startup
@Singleton
public class PoolManager {
	
	private Queue<Object> pooledObj;
	
	public PoolManager() {
		
	}
	
	@AccessTimeout(value =30, unit=TimeUnit.SECONDS)
	@Lock(LockType.WRITE)
	public void returnObject(Object object) {
		pooledObj.offer(object);
	}
	
	@Lock(LockType.READ)
	public Object borrowObject() {
		return pooledObj.poll();
	}
	
	@PostConstruct
	public void constructExpensiveObjects() {
		pooledObj = new LinkedBlockingQueue<>(1_000);
		for (int i=0; i  <= 1000; i++) {
			pooledObj.offer(new Object());
		}
	}
	

}
