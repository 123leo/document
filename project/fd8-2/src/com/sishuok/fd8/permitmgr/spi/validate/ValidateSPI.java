package com.sishuok.fd8.permitmgr.spi.validate;

import com.sishuok.fd8.permitmgr.dispatch.vo.PermitDispatchModel;

public interface ValidateSPI {
	public int getResourceIdByPath(String resourcePath);
	public int getPermitIdByName(String permitName);
	public int getRPIdByResIdAndPerId(int resId,int perId);
	public int judgeUserPermit(int userId,int resAndPerId);
	
	public int getRoleIdByVerifyName(String verifyName);
	public int judgeUserRole(int userId,int roleId);
	
	
}
