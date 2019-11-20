package com.sishuok.fd6.l2.business;

public class L2Factory {
	private L2Factory(){}
	public static IL2 createIL2(){
		return new  L2Service();
	}
}
