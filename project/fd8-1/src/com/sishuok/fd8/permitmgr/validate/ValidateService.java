package com.sishuok.fd8.permitmgr.validate;

import java.util.List;

public class ValidateService implements IValidate{

	@Override
	public boolean hasPermit(int userId, String resourcePath, String permitName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPermitAnd(int userId, String resourcePath,
			List<String> permitNames) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPermitOR(int userId, String resourcePath,
			List<String> permitNames) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRole(int userId, String roleVerifyName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRole(int userId, List<String> roleVerifyNames) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPermitByExpr(int userId, String resourcePath, String expr) {
		// TODO Auto-generated method stub
		return false;
	}
}
