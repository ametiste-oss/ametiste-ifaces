package org.ametiste.ifaces.api.error;

public interface ApiErrorMappingStrategy {

	void map(ErrorView view, Throwable throwable);

}
