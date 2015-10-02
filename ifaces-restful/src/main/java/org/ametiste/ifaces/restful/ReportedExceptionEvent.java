package org.ametiste.ifaces.restful;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationEvent;

// TODO: rename to HttpRequestHandlingExceptionEvent
public class ReportedExceptionEvent extends ApplicationEvent {

	private static final long serialVersionUID = 576763029904362836L;

	private final UUID requestId;
	
	private final HttpServletRequest request;
	
	private final Exception exception;

	public ReportedExceptionEvent(Object source, UUID requestId, HttpServletRequest request, Exception ex) {
		super(source);
		this.requestId = requestId;
		this.request = request;
		this.exception = ex;
	}

	public UUID getRequestId() {
		return requestId;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public Exception getException() {
		return exception;
	}

}
