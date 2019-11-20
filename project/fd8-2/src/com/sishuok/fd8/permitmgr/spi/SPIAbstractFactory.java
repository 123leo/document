package com.sishuok.fd8.permitmgr.spi;

import com.sishuok.fd8.permitmgr.spi.dispatch.DispatchDAO;
import com.sishuok.fd8.permitmgr.spi.validate.ValidateSPI;

public interface SPIAbstractFactory<M> {
	public DispatchDAO<M> createDispatchDAO();
	
	public ValidateSPI createValidateSPI();
}
