package com.sishuok.fd6.l2.business;

import java.util.List;

import com.sishuok.fd6.l2.messagetrans.SendMsgFactory;

public class L2Service implements IL2{

	@Override
	public boolean connectMes(int lid) {
		//1：准备连接的msg
		String msg = new MessageDirector(new MessageBuilder()).buildFM1(lid);
		//2：发送msg		//3：接收到返回msg
		String backMsg = SendMsgFactory.createISendMsg().sendMsg2Mes(msg);
		//4：对返回msg进行处理
		
		
		//5：启动心跳电文线程
		new HeartBeatThread(lid).start();
		
		return false;
	}
	private class HeartBeatThread extends Thread{
		private int lid ;
		public HeartBeatThread(int lid){
			this.lid = lid;
		}
		public void run(){
			while(true){
				String msg = new MessageDirector(new MessageBuilder()).buildFM2(lid);
				String backMsg = SendMsgFactory.createISendMsg().sendMsg2Mes(msg);
				
				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String applyPDI(int lid) {
		//1：准备连接的msg
		String msg = new MessageDirector(new MessageBuilder()).buildFM3(lid);
		//2：发送msg		//3：接收到返回msg
		String backMsg = SendMsgFactory.createISendMsg().sendMsg2Mes(msg);
				
		return backMsg;
	}

	@Override
	public String applyPlan(int lid,List<String> pdis) {
		//1：准备连接的msg
		String msg = new MessageDirector(new MessageBuilder()).buildFM4(lid,pdis);
		//2：发送msg		//3：接收到返回msg
		String backMsg = SendMsgFactory.createISendMsg().sendMsg2Mes(msg);
				
		return backMsg;
	}

	@Override
	public boolean producePlan(int lid,List<String> pdis) {
		//1：准备连接的msg
		String msg = new MessageDirector(new MessageBuilder()).buildFM5(lid,pdis);
		//2：发送msg		//3：接收到返回msg
		String backMsg = SendMsgFactory.createISendMsg().sendMsg2Mes(msg);
		
		//这里需要判断返回值		
		return false;
	}

	@Override
	public void rejectPDI(int lid,List<String> pdis) {
		//1：准备连接的msg
		String msg = new MessageDirector(new MessageBuilder()).buildFM6(lid,pdis);
		//2：发送msg		//3：接收到返回msg
		String backMsg = SendMsgFactory.createISendMsg().sendMsg2Mes(msg);
				
	}

	@Override
	public void successPDI(int lid,List<String> pdis) {
		//1：准备连接的msg
		String msg = new MessageDirector(new MessageBuilder()).buildFM7(lid,pdis);
		//2：发送msg		//3：接收到返回msg
		String backMsg = SendMsgFactory.createISendMsg().sendMsg2Mes(msg);
				
	}
	
}
