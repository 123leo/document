package com.sishuok.fd6.l2.business;

public class MessageBuilder {
	//FM001:加热炉编号
	//FM002:加热炉编号
	//FM003:加热炉编号
	//FM004:加热炉编号,PDI号1|PDI号2|PDI号3.....
	//FM005:加热炉编号,PDI号1|PDI号3|PDI号2.....  //这个顺序和上面一个并不完全一样
	//FM006:加热炉编号,拒绝的PDI号1|拒绝的PDI号2.....
	//FM007:加热炉编号,生产的PDI号1|生产的PDI号2.....
	
	private StringBuffer buffer = new StringBuffer();
	
	public String getProduct(){
		System.out.println("now getProduct==========");
		return buffer.toString();
	}
	//
	public MessageBuilder buildMsgType(String type){
		this.buffer.append(type+":");
		return this;
	}
	public MessageBuilder buildLid(int lid){
		this.buffer.append(lid);
		return this;
	}
	public MessageBuilder buildComma(){
		this.buffer.append(",");
		return this;
	}
	public MessageBuilder buildPDI(String pdi){
		this.buffer.append(pdi);
		return this;
	}
	public MessageBuilder buildVertical(){
		this.buffer.append("|");
		return this;
	}
}
