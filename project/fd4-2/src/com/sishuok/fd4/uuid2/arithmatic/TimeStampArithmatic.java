package com.sishuok.fd4.uuid2.arithmatic;

import java.util.Date;

public class TimeStampArithmatic implements IArithmatic{

	@Override
	public String genUuid(String businessType) {
		return businessType + new Date().getTime();
	}

}
