package com.sishuok.fd4.uuid2;

import com.sishuok.fd4.uuid2.arithmatic.IArithmatic;

public interface IUuid {
	public String genUuid(String businessType,
			boolean needFormat,String formatStr,String c,int len,
			boolean needArithmatic,IArithmatic ia);
	
	//×ÖµÚ001 ºÅ
	//20
}
