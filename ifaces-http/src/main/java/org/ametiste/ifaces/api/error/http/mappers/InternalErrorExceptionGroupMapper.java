package org.ametiste.ifaces.api.error.http.mappers;

import org.ametiste.ifaces.api.error.CommonApiError;
import org.ametiste.ifaces.api.error.mappers.CommonGroupErrorMapper;

public class InternalErrorExceptionGroupMapper extends CommonGroupErrorMapper {

	private static CommonApiError error = CommonApiError.INTERNAL_ERROR;

	public InternalErrorExceptionGroupMapper() {
		super(error);
		super.addSupportedException(Throwable.class);
	}

}
