package com.sishuok.fd4.uuid2;

import com.sishuok.fd4.uuid2.arithmatic.DefaultArithmatic;
import com.sishuok.fd4.uuid2.arithmatic.IArithmatic;

public class UuidService implements IUuid{

	@Override
	public String genUuid(String businessType, boolean needFormat,
			String formatStr, String c, int len, boolean needArithmatic,
			IArithmatic ia) {
		IArithmatic arithmatic = null; 
		//1：判断是否需要采用客户指定的算法
		if(needArithmatic){
			arithmatic = ia;
		}else{
			arithmatic = new DefaultArithmatic();
		}
		//2：得到一个流水号
		String uuid = arithmatic.genUuid(businessType);
		//3:判断是否需要格式化
		if(needFormat){
			uuid = this.formatUuid(formatStr, c, len, uuid);
		}
		return uuid;
	}
	private String formatUuid(String formatStr, String c, int len,String uuid){
		uuid = this.prepareUuid(c, len, uuid);
		return formatStr.replaceAll("#", uuid);		
	}
	private String prepareUuid(String c, int len,String uuid){
		if(uuid.length() > len){
			uuid = uuid.substring(0,len);
		}else if(uuid.length() < len){
			//需要填充
			String preStr = "";
			for(int i=0;i<(len-uuid.length());i++){
				preStr += c;
			}
			uuid = preStr + uuid;
		}
		return uuid;
	}
}
