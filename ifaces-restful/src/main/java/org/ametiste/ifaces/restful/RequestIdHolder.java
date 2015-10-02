package org.ametiste.ifaces.restful;

import java.util.UUID;

// TODO: rename to ApiRequestIdHolder
public class RequestIdHolder {

	private final UUID requestId;
	
	public RequestIdHolder() {
		requestId = UUID.randomUUID();
	}
	
	public UUID getRequestId() {
		return requestId;
	}
	
}
