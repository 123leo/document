package com.sishuok.fd6.l2.business;

public class MessageBuilder {
	//FM001:����¯���
	//FM002:����¯���
	//FM003:����¯���
	//FM004:����¯���,PDI��1|PDI��2|PDI��3.....
	//FM005:����¯���,PDI��1|PDI��3|PDI��2.....  //���˳�������һ��������ȫһ��
	//FM006:����¯���,�ܾ���PDI��1|�ܾ���PDI��2.....
	//FM007:����¯���,������PDI��1|������PDI��2.....
	
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
