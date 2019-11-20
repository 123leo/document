package com.sishuok.fd6.l2.messagetrans.server;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class L2Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1112);
			
			while(true){
				Socket s = ss.accept();
				
				ObjectInputStream in = new ObjectInputStream(
						new BufferedInputStream(s.getInputStream())
				);
				Object obj = in.readObject();
				System.out.println("now L2Server msg===="+obj);
				//ºóÐø²Ù×÷
				in.close();
				s.close();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
