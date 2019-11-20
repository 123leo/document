package com.sishuok.fd8.permitmgr.dispatch.base;

import java.util.List;

public interface IService<M>{
	public void create(M m);
	public void update(M m);
	public void delete(M m);
	
	public M getById(int id);
	public List<M> getByCondition(M m,int begin,int pageSize);
}
