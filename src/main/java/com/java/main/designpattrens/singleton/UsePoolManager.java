package com.java.main.designpattrens.singleton;

import javax.inject.Inject;

public class UsePoolManager {

@Inject
private PoolManager poolManager;

public void usePooledObj() {
	Object obj = poolManager.borrowObject();
	// use the object
	poolManager.returnObject(obj);
}
}
