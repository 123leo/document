package com.sishuok.fd8.permitmgr.validate;

import java.util.List;

public interface IValidate {
	public boolean hasPermit(int userId,String resourcePath,String permitName);
	/**
	 * 
	 * @param userId
	 * @param resourcePath
	 * @param permitNames ͬʱ������Ȩ��
	 * @return
	 */
	public boolean hasPermitAnd(int userId,String resourcePath,List<String> permitNames);
	/**
	 * 
	 * @param userId
	 * @param resourcePath
	 * @param permitNames ֻҪ����ЩȨ���е�һ���Ϳ�����
	 * @return
	 */
	public boolean hasPermitOR(int userId,String resourcePath,List<String> permitNames);
	
	
	public boolean isRole(int userId,String roleVerifyName);
	/**
	 * 
	 * @param userId
	 * @param roleVerifyNames  ֻҪ����Щ��ɫ�е�һ���Ϳ�����
	 * @return
	 */
	public boolean isRole(int userId,List<String> roleVerifyNames);
	
	
	
	/**
	 * ��۷�����һ���ԵĽ���������е���֤����
	 * @param userId
	 * @param resourcePath
	 * @param expr Ҫ��֤��Ȩ����ϵı���ʽ
	 * @return
	 */
	
	// P:p1 || (P:p2 && P:p3))
	// R:r1 || (P:p1 || (P:p2 && P:p3))
	//1��ʹ��Java�Ļ�������ʽ���﷨��ֻ֧��  && �� || �� !
	//2����Ȩ������ǰ�� P���� �ڽ�ɫ����ǰ�� R��
	public boolean hasPermitByExpr(int userId,String resourcePath,String expr);
	
//	R:r1                          true
//		P:p1                           false
//			P:p2                            true
//				P:p3                            false
//                Terminal      ִ������ boolean �ַ���  true || (false || (true && false))
	
	
	
	
}