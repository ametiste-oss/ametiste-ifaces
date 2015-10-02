package org.ametiste.ifaces.api.error.http;

import org.ametiste.ifaces.api.error.ErrorRender;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class HttpError {

	private HttpStatus status;
	private ErrorRender body;
	private Map<String, Object> headers;

	public HttpStatus getStatus() {
		return status;
	}

	public ErrorRender getBody() {
		return body;
	}

	public Map<String, Object> getHeaders() {
		return headers;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;

	}

	void setBody(ErrorRender body) {
		this.body = body;

	}

	void setHeaders(Map<String, Object> headers) {
		this.headers = headers;

	}


}
