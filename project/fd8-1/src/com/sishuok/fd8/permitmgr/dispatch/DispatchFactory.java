package com.sishuok.fd8.permitmgr.dispatch;

import com.sishuok.fd8.permitmgr.dispatch.api.IPermit;
import com.sishuok.fd8.permitmgr.dispatch.api.IPermitDispatch;
import com.sishuok.fd8.permitmgr.dispatch.api.IResource;
import com.sishuok.fd8.permitmgr.dispatch.api.IResourcePermit;
import com.sishuok.fd8.permitmgr.dispatch.api.IRole;
import com.sishuok.fd8.permitmgr.dispatch.api.IUser;
import com.sishuok.fd8.permitmgr.dispatch.api.IUserRole;

public class DispatchFactory {
	private DispatchFactory(){}
	
	public static IPermit createIPermit(){
		return null;
	}
	public static IPermitDispatch createIPermitDispatch(){
		return null;
	}
	public static IResource createIResource(){
		return null;
	}
	public static IResourcePermit createIResourcePermit(){
		return null;
	}
	public static IRole createIRole(){
		return null;
	}
	public static IUser createIUser(){
		return null;
	}
	public static IUserRole createIUserRole(){
		return null;
	}
	
}
