package org.ametiste.ifaces.api.error;

public interface ApiErrorMapper {

	ApiError getErrorByException(Exception e); //TODO think about where it should be placed

}
