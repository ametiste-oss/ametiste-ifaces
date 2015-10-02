package org.ametiste.ifaces.api.error.http.mappers;

import org.ametiste.ifaces.api.ServiceUnavailableException;
import org.ametiste.ifaces.api.error.CommonApiError;
import org.ametiste.ifaces.api.error.mappers.CommonGroupErrorMapper;

public class ServiceUnavailableExceptionGroupMapper extends CommonGroupErrorMapper {

	private final static CommonApiError error = CommonApiError.SERVICE_UNAVAILABLE;

	public ServiceUnavailableExceptionGroupMapper() {
		super(error);
		super.addSupportedException(ServiceUnavailableException.class);
	}

}
