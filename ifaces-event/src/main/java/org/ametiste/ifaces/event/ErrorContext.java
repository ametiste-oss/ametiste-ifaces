package org.ametiste.ifaces.event;

import java.io.Serializable;
import java.util.HashMap;

public class ErrorContext {

	private final HashMap<String, Serializable> context;
	
	public ErrorContext() {
		context = new HashMap<String, Serializable>();
	}

	public ErrorContext append(String name, Serializable value) {
		context.put(name, value);
		return this;
	}

	public HashMap<String, Serializable> getContext() {
		return this.context;
	}
}

