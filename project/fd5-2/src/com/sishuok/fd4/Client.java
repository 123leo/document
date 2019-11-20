package com.sishuok.fd4;

import com.sishuok.fd4.uuid1.Uuid1Factory;
import com.sishuok.fd4.uuid2.Uuid2Factory;
import com.sishuok.fd4.uuid2.arithmatic.IArithmatic;
import com.sishuok.fd4.uuid2.arithmatic.TimeStampArithmatic;

public class Client {
	public static void main(String[] args) {
		for(int i=0;i<11;i++){
//			int uuid =  Uuid1Factory.createIUuid().genUuid("Doc");
//			System.out.println("doc uuid1==="+uuid);
//			uuid =  Uuid1Factory.createIUuid().genUuid("Doc");
//			System.out.println("doc uuid2==="+uuid);
//			uuid =  Uuid1Factory.createIUuid().genUuid("File");
//			System.out.println("File uuid==="+uuid);
//		}
		
		IArithmatic ia = new TimeStampArithmatic();
		
		String uuid =  Uuid2Factory.createIUuid().genUuid("Doc"
				,true,"×ÖµÚ # ºÅ","0",30,true,ia
				);
		System.out.println("doc uuid1==="+uuid);
		uuid =  Uuid2Factory.createIUuid().genUuid("Doc"
				,false,"×ÖµÚ # ºÅ","0",30,false,null
				);
		System.out.println("doc uuid2==="+uuid);
		uuid =  Uuid2Factory.createIUuid().genUuid("Doc"
				,false,"×ÖµÚ # ºÅ","0",30,true,ia
				);
		System.out.println("doc uuid3==="+uuid);
		}
	}
}
