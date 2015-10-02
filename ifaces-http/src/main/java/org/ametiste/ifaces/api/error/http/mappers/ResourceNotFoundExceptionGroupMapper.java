package org.ametiste.ifaces.api.error.http.mappers;

import org.ametiste.ifaces.api.ResourceNotFoundException;
import org.ametiste.ifaces.api.error.CommonApiError;
import org.ametiste.ifaces.api.error.mappers.CommonGroupErrorMapper;

public class ResourceNotFoundExceptionGroupMapper extends CommonGroupErrorMapper {

	private static CommonApiError error = CommonApiError.RESOURCE_NOT_FOUND;

	public ResourceNotFoundExceptionGroupMapper() {
		super(error);
		super.addSupportedException(ResourceNotFoundException.class);
		// super.setSupportedExceptions(set);

	}


}
