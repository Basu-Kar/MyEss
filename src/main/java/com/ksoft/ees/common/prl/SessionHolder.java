package com.ksoft.ees.common.prl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="session",proxyMode=ScopedProxyMode.INTERFACES)
public class SessionHolder implements ISessionHolder{

	private Map<String,Object> sessionMap=new HashMap<String,Object>();

	public Object getSessionObject(String key) {
		return sessionMap.get(key);
	}

	public void putSessionObject(String key, Object value) {
		sessionMap.put(key, value);
	}
	
	
}
