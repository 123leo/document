package com.sishuok.fd6.l2.business;

import java.util.List;

public interface IL2 {
	public boolean connectMes(int lid);
	public String applyPDI(int lid);
	public String applyPlan(int lid,List<String> pdis);
	public boolean producePlan(int lid,List<String> pdis);
	public void rejectPDI(int lid,List<String> pdis);
	public void successPDI(int lid,List<String> pdis);	
}
