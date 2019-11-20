package com.sishuok.fd6.l2.business;

import java.util.List;

public class MessageDirector {
	private MessageBuilder mb= null;
	public MessageDirector(MessageBuilder mb){
		this.mb = mb;
	}	
	
	public String buildFM1(int lid){
		//备忘录的客户端
		return baseMsg(Constant.FM1,lid);
	}
	private String baseMsg(String type,int lid){
		Object obj = CareTaker.getMemento(type+lid);
		if(obj!=null){
			return ((MsgMemento)obj).getMsg();
		}else{
			String msg = mb.buildMsgType(type)
					.buildLid(lid).getProduct();
			CareTaker.setMemento(type+lid, new MsgMemento(msg));
			return msg;
		}
	}
	public String buildFM2(int lid){
		//备忘录的客户端
		return baseMsg(Constant.FM2,lid);
	}
	public String buildFM3(int lid){
		//备忘录的客户端
		return baseMsg(Constant.FM3,lid);
	}
	public String buildFM4(int lid,List<String> pdis){
		//备忘录的客户端
		String preMsg = baseMsg(Constant.FM4,lid);
	
		return appendPdis(preMsg,pdis);
	}
	
	public String buildFM5(int lid,List<String> pdis){
		//备忘录的客户端
		String preMsg = baseMsg(Constant.FM5,lid);
	
		return appendPdis(preMsg,pdis);
	}
	public String buildFM6(int lid,List<String> pdis){
		//备忘录的客户端
		String preMsg = baseMsg(Constant.FM6,lid);
	
		return appendPdis(preMsg,pdis);
	}
	public String buildFM7(int lid,List<String> pdis){
		//备忘录的客户端
		String preMsg = baseMsg(Constant.FM7,lid);
	
		return appendPdis(preMsg,pdis);
	}
	private String appendPdis(String preMsg,List<String> pdis){
		preMsg +=",";
		for(String pdi : pdis){
			preMsg += pdi+"|";
		}
		preMsg = preMsg.substring(0,preMsg.length()-1);
		return preMsg;
	}
	
	
	private static class MsgMemento implements IMsgMemento{
		private String msg = "";
		
		public MsgMemento(String msg){
			this.msg = msg;
		}
		public String getMsg(){
			return msg;
		}
	}
}
