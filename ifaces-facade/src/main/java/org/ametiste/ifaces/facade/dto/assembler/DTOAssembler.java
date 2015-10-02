package org.ametiste.ifaces.facade.dto.assembler;

import java.util.List;

public interface DTOAssembler<F, T> {

	T assembleDTO(F object);
	
	List<T> assembleDTOList(List<F> objectsList);
	
}
