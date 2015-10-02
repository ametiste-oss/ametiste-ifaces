package org.ametiste.ifaces.api.error.mappers;

import java.util.HashSet;
import java.util.Set;

import org.ametiste.ifaces.api.error.ApiError;
import org.ametiste.ifaces.api.error.ErrorView;

public class CommonGroupErrorMapper implements ErrorMapper {

	private final ApiError error;
	private final Set<Class<? extends Throwable>> supportedExceptions;

	public CommonGroupErrorMapper(ApiError error) {
		this.error = error;
		supportedExceptions = new HashSet<Class<? extends Throwable>>();
	}

	@Override
	public boolean supports(Throwable e) {
		for (Class<? extends Throwable> supportedEx : supportedExceptions) {
			if (supportedEx.isAssignableFrom(e.getClass())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void update(ErrorView view) {
		view.addCode(error.getCode());
		view.addMessage(error.getMessage());

	}

	public void setSupportedExceptions(Set<Class<? extends Throwable>> set) {
		supportedExceptions.addAll(set);
	}

	public void addSupportedException(Class<? extends Throwable> exceptionClass) {
		supportedExceptions.add(exceptionClass);
	}

	
}
