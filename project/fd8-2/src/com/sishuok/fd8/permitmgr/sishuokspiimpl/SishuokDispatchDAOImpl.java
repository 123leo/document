package com.sishuok.fd8.permitmgr.sishuokspiimpl;

public class SishuokDispatchDAOImpl<M> extends DispatchDAOImpl<M>{

	@Override
	protected boolean judgeCondition(M m, M model) {
		String name = m.getClass().getName();
		if(name.contains(".PermitModel")){
			return judgePermitName(m,model);
		}else if(name.contains(".RoleModel")){
			return judgeRoleVerifyName(m,model);
		}else if(name.contains(".ResourceModel")){
			return judgeResourcePath(m,model);
		}else if(name.contains(".ResourcePermitModel")){
			return judgeResourcePermit(m,model);
		}else if(name.contains(".UserRoleModel")){
			return judgeUserRoles(m,model);
		}else if(name.contains(".PermitDispatchModel")){
			return judgePermitDispatchModel(m,model);
		}
		return false;
	}
	private boolean judgePermitDispatchModel(M m, M model){
		return hasValue(m, model, "userOrRoleId=", ",") && hasValue(m, model, "type=", ",") 
				&& hasValue(m, model, "resourcePermitId=", "]");
	}
	private boolean judgeUserRoles(M m, M model){
		return hasValue(m, model, "userId=", ",") && hasValue(m, model, "roleId=", "]");
	}
	private boolean judgeResourcePermit(M m, M model){
		return hasValue(m, model, "resourceId=", ",") && hasValue(m, model, "permitId=", "]");
	}
	private boolean judgeResourcePath(M m, M model){
		return hasValue(m,model,"path=",",");
	}
	private boolean judgeRoleVerifyName(M m, M model){
		return hasValue(m,model,"verifyName=",",");
	}
	private boolean judgePermitName(M m, M model){
		return hasValue(m, model, "name=", "]");
	}
	private boolean hasValue(M m,M model,String str,String endStr){
		int nameSite1 = m.toString().indexOf(str)+str.length();
		int nameSite2 = nameSite1 + m.toString().substring(nameSite1).indexOf(endStr);
		String name = m.toString().substring(nameSite1,nameSite2);
		if(model.toString().contains(str+name)){
			return true;
		}
		return false;
	}

}
