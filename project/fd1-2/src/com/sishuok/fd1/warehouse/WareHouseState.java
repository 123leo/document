package com.sishuok.fd1.warehouse;

public enum WareHouseState {
	waitPrePare("´ý±¸»õ"),waitOut("´ý³ö¿â");

	private String state;
	private WareHouseState(String state){
		this.state = state;
	}
	
	public String getState(){
		return this.state;
	}
}
