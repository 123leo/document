package com.sishuok.fd4.uuid2;

import com.sishuok.fd5.uuid3.Uuid3Factory;
import com.sishuok.fd5.uuid3.arithmatic.IArithmatic;

public class Uuid3Adapter implements IUuid{

	@Override
	public String genUuid(String businessType, boolean needFormat,
			String formatStr, String c, int len, boolean needArithmatic,
			com.sishuok.fd4.uuid2.arithmatic.IArithmatic ia) {
		return Uuid3Factory.createIUuid()
				.genUuid(businessType, needFormat, formatStr, c, len, false, null, 10);
		 
	}
}
