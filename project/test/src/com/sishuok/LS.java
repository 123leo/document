package com.sishuok;

import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class LS {
	public static void main(String[] args) {
//		try {
//			ServerSocket ss = new ServerSocket(1111);
//			while(true){
//				Socket s = ss.accept();
//				
//				ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
//				
//				Object obj = oin.readObject();
//				System.out.println("ls===="+obj);
//				oin.close();				
//			}	
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
		
		try {
			Object obj = jse.eval("((true && false) || true) || false && false");
			System.out.println(obj);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
