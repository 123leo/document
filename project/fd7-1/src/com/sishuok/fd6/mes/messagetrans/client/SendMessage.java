package com.sishuok.fd6.mes.messagetrans.client;

import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SendMessage {
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
		try {
			Socket s = new Socket("localhost",1112);
			
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(s.getOutputStream())
			);
			out.writeObject("now test111==="+i);
			out.close();
			s.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
}
