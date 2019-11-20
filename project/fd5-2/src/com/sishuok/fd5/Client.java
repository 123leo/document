package com.sishuok.fd5;

import com.sishuok.fd5.uuid3.Uuid3Factory;

public class Client {
	public static void main(String[] args) {
		
		for(int i=0;i<21;i++){
			String uuid =  Uuid3Factory.createIUuid().genUuid("Doc"
					,true,"×ÖµÚ # ºÅ","0",30,false,null,5
					);
			System.out.println("doc uuid1==="+uuid);
		}
	}
}
