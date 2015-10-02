package org.ametiste.ifaces.api.error;

import java.util.Collections;
import java.util.Map;

// TODO: rename to ApiCommonError to hold up one Api* prefix for all related artifacts
public enum CommonApiError implements ApiError {

	SERVICE_UNAVAILABLE("ServiceUnavailable", "Service currently is not available, try later."),
	
	INTERNAL_ERROR("InternalError", "We encountered an internal error. Please try again."),
	
	RESOURCE_NOT_FOUND("ResourceNotFound", "Resource can't be found."),
	
	BAD_REQUEST("BadRequest", "Request is not supported by service. Please read documentation");

	private final String code;

	private final String message;

	private final Map<String, String> properties;

	CommonApiError(final String code, final String message) {
		this(code, message, Collections.<String, String> emptyMap());
	}

	CommonApiError(final String code, final String message, final Map<String, String> properties) {
		this.code = code;
		this.message = message;
		this.properties = properties;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Map<String, String> getProperties() {
		return properties;
	}

	@Override
	public boolean hasProperties() {
		return !properties.isEmpty();
	}

}
