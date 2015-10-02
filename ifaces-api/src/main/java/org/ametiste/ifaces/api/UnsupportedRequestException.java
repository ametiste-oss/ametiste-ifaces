package org.ametiste.ifaces.api;

public class UnsupportedRequestException extends RuntimeException {

	//TODO think about where it should be placed
	private static final long serialVersionUID = 7071826308307828360L;

	public UnsupportedRequestException(String message) {
		super(message);
	}

	public UnsupportedRequestException(Exception e) {
		super(e);
	}

	public UnsupportedRequestException(String message, Exception e) {
		super(message, e);
	}

}
