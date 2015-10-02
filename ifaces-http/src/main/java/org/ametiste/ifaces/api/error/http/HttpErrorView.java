package org.ametiste.ifaces.api.error.http;

import org.ametiste.ifaces.api.error.ErrorRender;
import org.ametiste.ifaces.api.error.ErrorView;

public class HttpErrorView implements ErrorView {

	private String code;
	private String message;
	private final StatusMappingStrategy statusMapping;
	private final String requestId;

	public HttpErrorView(String requestId, StatusMappingStrategy statusMapping) {

		this.requestId = requestId;
		this.statusMapping = statusMapping;

	}

	@Override
	public void addCode(String code) {
		this.code = code;
	}

	@Override
	public void addMessage(String message) {

		this.message = message;

	}

	public HttpError build() {

		if (!dataExist()) {
			throw new IllegalStateException("No proper data set");
		}

		HttpError error = new HttpError();
		error.setBody(new ErrorRender(code, message, requestId));
		statusMapping.mapErrorCodeToStatus(code, error);
		
		return error;
	}

	@Override
	public boolean allowsUpdate() {
		if (dataExist()) {
			return false;
		}
		return true;
	}

	private boolean dataExist() {
		return code != null && message != null;
	}
}
