package org.ametiste.ifaces.api.error.http.mappers;

import org.ametiste.ifaces.api.UnsupportedRequestException;
import org.ametiste.ifaces.api.error.CommonApiError;
import org.ametiste.ifaces.api.error.mappers.CommonGroupErrorMapper;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.ServletRequestBindingException;

public class BadRequestExceptionGroupMapper extends CommonGroupErrorMapper {

	private static CommonApiError error = CommonApiError.BAD_REQUEST;

	public BadRequestExceptionGroupMapper() {
		super(error);
		super.addSupportedException(TypeMismatchException.class);
		super.addSupportedException(ServletRequestBindingException.class);
		super.addSupportedException(UnsupportedRequestException.class);
	}

}
