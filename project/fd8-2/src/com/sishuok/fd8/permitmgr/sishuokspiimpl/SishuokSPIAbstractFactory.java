package com.sishuok.fd8.permitmgr.sishuokspiimpl;

import com.sishuok.fd8.permitmgr.spi.SPIAbstractFactory;
import com.sishuok.fd8.permitmgr.spi.dispatch.DispatchDAO;
import com.sishuok.fd8.permitmgr.spi.validate.ValidateSPI;

public class SishuokSPIAbstractFactory<M> implements SPIAbstractFactory<M>{

	@Override
	public DispatchDAO<M> createDispatchDAO() {
		return new SishuokDispatchDAOImpl<M>();
	}

	@Override
	public ValidateSPI createValidateSPI() {
		return new SishuokValidateSPIImpl();
	}

}
