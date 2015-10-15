package org.ametiste.ifaces.restful;

import org.ametiste.ifaces.api.error.ApiErrorMappingStrategy;
import org.ametiste.ifaces.api.error.http.HttpError;
import org.ametiste.ifaces.api.error.http.HttpErrorView;
import org.ametiste.ifaces.api.error.http.StatusMappingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ApiControllerMappingAdvice implements InitializingBean {

    public static final String ERROR_PAGE_VIEW_NAME = "ameApiErrorPageView";

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected RequestIdHolder requestIdHolder;

	@Autowired
	@Qualifier("statusMappingStrategy")
	private StatusMappingStrategy statusMapperStrategy;

	@Autowired
	@Qualifier("errorMappingStrategy")
	private ApiErrorMappingStrategy mappingStrategy;

	public void setMappingStrategy(ApiErrorMappingStrategy mappingStrategy) {
		this.mappingStrategy = mappingStrategy;

	}

	public void setStatusMappingStrategy(StatusMappingStrategy strategy) {
		this.statusMapperStrategy = strategy;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(final Exception e, HttpServletResponse response) {

		HttpErrorView view = new HttpErrorView(requestIdHolder.getRequestId().toString(), statusMapperStrategy);
		mappingStrategy.map(view, e);
		HttpError error = view.build();

		response.setStatus(error.getStatus().value());

		ModelAndView mv = new ModelAndView(ERROR_PAGE_VIEW_NAME);
		mv.addObject("code", error.getBody().code);
		mv.addObject("request_id", error.getBody().request_id);
		mv.addObject("message", error.getBody().message);

		return mv;

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(statusMapperStrategy);
		Assert.notNull(mappingStrategy);

	}

}

