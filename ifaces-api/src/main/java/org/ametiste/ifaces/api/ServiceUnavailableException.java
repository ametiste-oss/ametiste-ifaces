package org.ametiste.ifaces.api;

public class ServiceUnavailableException extends RuntimeException {

	private static final long serialVersionUID = -4147577878449051340L;

	public ServiceUnavailableException(String message) {
		super(message);
	}

	public ServiceUnavailableException(Exception e) {
		super(e);
	}

	public ServiceUnavailableException(String message, Exception e) {
		super(message, e);
	}
	
}
