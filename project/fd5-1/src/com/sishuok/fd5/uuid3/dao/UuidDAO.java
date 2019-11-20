package com.sishuok.fd5.uuid3.dao;

import com.sishuok.fd5.uuid3.UuidVO;

public interface UuidDAO {
	public UuidVO getByBusinessType(String businessType);
	public void updateUuid(UuidVO uuidVo);
	public void createUuid(UuidVO uuidVo);
}
