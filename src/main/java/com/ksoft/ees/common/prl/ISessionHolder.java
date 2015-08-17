package com.ksoft.ees.common.prl;


public interface ISessionHolder {

	public Object getSessionObject(String key);

	public void putSessionObject(String key, Object value);
	
}
