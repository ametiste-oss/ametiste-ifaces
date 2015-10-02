package org.ametiste.ifaces.api.error.http;

public interface StatusMappingStrategy {

	void mapErrorCodeToStatus(String code, HttpError error);

}
