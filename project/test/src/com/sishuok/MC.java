package com.sishuok;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class MC {
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("localhost",1111);
		ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
		
		out.writeObject("����һ������111");
		
		out.close();
		s.close();
		
		
		Socket s2 = new Socket("localhost",1111);
		ObjectOutputStream out2 = new ObjectOutputStream(s2.getOutputStream());
		
		out2.writeObject(new UserModel(1,"����һ������222"));
		
		out2.close();
		s2.close();
	}
}
