package org.ametiste.ifaces.api;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Exception e) {
		super(e);
	}

	public ResourceNotFoundException(String message, Exception e) {
		super(message, e);
	}

}
