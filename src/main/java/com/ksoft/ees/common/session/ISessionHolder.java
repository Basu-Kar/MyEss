package com.ksoft.ees.common.session;

import java.io.Serializable;

public interface ISessionHolder<T> extends Serializable{

	public T getValue(String key);

	public void putValue(String key, T value);
}
