package com.sishuok;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MS {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1112);
			while(true){
				Socket s = ss.accept();
				
				ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
				
				Object obj = oin.readObject();
				System.out.println("ms===="+obj);
				oin.close();				
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
