package com.sishuok.fd4.uuid1;

public interface IUuid {
	//api 的拆分与合并
	
//	public void changeState(int id,int state);///
//	
//	public void state2Over(int id);
//	public void state2WaitPrepare(int id);
	
	
	//api 易误用
	public int genUuid(String businessType);
	
	//api设计：正确性、易用、能避免误用、安全、性能
	//兼容性：源码级别， 二进制
}
