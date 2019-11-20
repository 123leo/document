package com.sishuok.fd4.uuid1.dao;

import com.sishuok.fd4.uuid1.UuidVO;

public interface UuidDAO {
	public UuidVO getByBusinessType(String businessType);
	public void updateUuid(UuidVO uuidVo);
	public void createUuid(UuidVO uuidVo);
}
