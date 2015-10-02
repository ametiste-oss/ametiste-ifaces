package org.ametiste.ifaces.api.error.http;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class SimpleStatusMapper implements StatusMappingStrategy {

	private final Map<String, HttpStatus> statusesMap;

	public SimpleStatusMapper() {
		statusesMap = new HashMap<String, HttpStatus>();
		statusesMap.put("ServiceUnavailable", HttpStatus.SERVICE_UNAVAILABLE);
		statusesMap.put("InternalError", HttpStatus.INTERNAL_SERVER_ERROR);
		statusesMap.put("ResourceNotFound", HttpStatus.NOT_FOUND);
		statusesMap.put("BadRequest", HttpStatus.BAD_REQUEST);
	}

	@Override
	public void mapErrorCodeToStatus(String code, HttpError error) {
		if (statusesMap.containsKey(code)) {
			error.setStatus(statusesMap.get(code));
		} else {
			error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * adds custom statuses or overwrites statuses with existing codes with required ones
	 * 
	 * @param statuses
	 */
	public void setCustomStatuses(Map<String, HttpStatus> statuses) {
		statusesMap.putAll(statuses);
	}

}
