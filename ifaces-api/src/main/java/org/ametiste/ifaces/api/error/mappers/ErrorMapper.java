package org.ametiste.ifaces.api.error.mappers;

import org.ametiste.ifaces.api.error.ErrorView;

public interface ErrorMapper {

	boolean supports(Throwable e);

	void update(ErrorView view);

}
