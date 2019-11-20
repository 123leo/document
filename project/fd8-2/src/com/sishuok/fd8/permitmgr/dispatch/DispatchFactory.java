package com.sishuok.fd8.permitmgr.dispatch;

import com.sishuok.fd8.permitmgr.dispatch.api.IPermit;
import com.sishuok.fd8.permitmgr.dispatch.api.IPermitDispatch;
import com.sishuok.fd8.permitmgr.dispatch.api.IResource;
import com.sishuok.fd8.permitmgr.dispatch.api.IResourcePermit;
import com.sishuok.fd8.permitmgr.dispatch.api.IRole;
import com.sishuok.fd8.permitmgr.dispatch.api.IUser;
import com.sishuok.fd8.permitmgr.dispatch.api.IUserRole;
import com.sishuok.fd8.permitmgr.dispatch.permit.PermitService;
import com.sishuok.fd8.permitmgr.dispatch.permitdispatch.PermitDispatchService;
import com.sishuok.fd8.permitmgr.dispatch.resource.ResourceService;
import com.sishuok.fd8.permitmgr.dispatch.resourcepermit.ResourcePermitService;
import com.sishuok.fd8.permitmgr.dispatch.role.RoleService;
import com.sishuok.fd8.permitmgr.dispatch.user.UserService;
import com.sishuok.fd8.permitmgr.dispatch.userrole.UserRoleService;

public class DispatchFactory {
	private DispatchFactory(){}
	
	public static IPermit createIPermit(){
		return new PermitService();
	}
	public static IPermitDispatch createIPermitDispatch(){
		return new PermitDispatchService();
	}
	public static IResource createIResource(){
		return new ResourceService();
	}
	public static IResourcePermit createIResourcePermit(){
		return new ResourcePermitService();
	}
	public static IRole createIRole(){
		return new RoleService();
	}
	public static IUser createIUser(){
		return new UserService();
	}
	public static IUserRole createIUserRole(){
		return new UserRoleService();
	}
	
}
