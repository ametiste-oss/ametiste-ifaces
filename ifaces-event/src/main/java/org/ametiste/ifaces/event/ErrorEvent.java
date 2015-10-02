package org.ametiste.ifaces.event;

import java.util.UUID;

import org.springframework.context.ApplicationEvent;

public class ErrorEvent extends ApplicationEvent {

	private final UUID requestId;
	private final Exception exception;
	private final ErrorContext context;

	public ErrorEvent(Object source, UUID requestId, ErrorContext context, Exception exception) {
		super(source);
		this.requestId = requestId;
		this.context = context;

		this.exception = exception;
	}

	public UUID getRequestId() {
		return requestId;
	}

	public Exception getException() {
		return exception;
	}

	public ErrorContext getContext() {
		return context;
	}

}
