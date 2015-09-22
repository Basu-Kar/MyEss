package com.ksoft.ees.common.session;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionHolder<T> implements ISessionHolder<T>{

	private Map<String,T> map=new HashMap<String,T>();

	public T getValue(String key) {
		return map.get(key);
	}

	public void putValue(String key, T value) {
		map.put(key, value);
	}
	
	
	
}
