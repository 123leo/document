package com.sishuok.fd6.l2.messagetrans.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.sishuok.fd6.l2.messagetrans.ISendMsg;

public class SendMsgProxy implements ISendMsg{

	@Override
	public String sendMsg2Mes(String msg) {
		try {
			Socket s = new Socket("localhost",1111);
			
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(s.getOutputStream())
			);
			out.writeObject(msg);
			out.flush();
			
			
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(s.getInputStream())
			);
			Object obj = in.readObject();
			
			
			
			
			System.out.println("now get back MesServer msg===="+obj);
			
			
			in.close();
			s.close();
			
			return ""+obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
