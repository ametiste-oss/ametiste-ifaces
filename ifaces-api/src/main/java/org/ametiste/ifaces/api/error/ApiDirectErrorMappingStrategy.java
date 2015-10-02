package org.ametiste.ifaces.api.error;

import java.util.List;

import org.ametiste.ifaces.api.error.mappers.ErrorMapper;


public class ApiDirectErrorMappingStrategy implements ApiErrorMappingStrategy {

	private List<ErrorMapper> mappers;

	public void setMappers(List<ErrorMapper> mappers) {
		this.mappers = mappers;

	}

	@Override
	public void map(ErrorView view, Throwable e) {
		for (ErrorMapper mapper : mappers) {
			if (!view.allowsUpdate()) {
				break;
			}
			if (mapper.supports(e)) {
				mapper.update(view);
			}
		}

	}

}
