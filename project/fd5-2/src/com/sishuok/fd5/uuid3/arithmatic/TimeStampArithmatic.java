package com.sishuok.fd5.uuid3.arithmatic;

import java.util.Date;

public class TimeStampArithmatic implements IArithmatic{

	@Override
	public String genUuid(String businessType,int cacheNum) {
		return businessType + new Date().getTime();
	}
}
