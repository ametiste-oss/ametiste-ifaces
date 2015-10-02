package org.ametiste.ifaces.restful;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class EventExceptionResolver implements HandlerExceptionResolver, ApplicationEventPublisherAware, Ordered {

	private ApplicationEventPublisher applicationEventPublisher;
	
	private RequestIdHolder requestIdHolder;
	
	private int order;

	/**
	 *  <p>
	 *  Creates resolver that will be first in a resolving chain.
	 *  It's required cos we want an event were published before
	 *  other resolver take flow and resolve valid view. 
	 *  </p>
	 */
	public EventExceptionResolver() { 
		
		/* 
		 * NOTE: it's only the default constructor allowed.
		 * We will dive into spring deeps, nobody knows how it will work.
		 * Say, aop proxy may occur or something else what needs a default constructor.
		 *
		 */
		
		// first in order by default, required to not be intercepted by real exception handler
		this.order = Integer.MIN_VALUE; 
	}
	
	// TODO: can we use an autowairing instead?
	// if we deep inside in spring we can allow to easy-mode this dependency
	// Need to try. Dunno how autowired and xml-defined beans will do together
	public void setRequestIdHolder(RequestIdHolder requestIdHolder) {
		this.requestIdHolder = requestIdHolder;
	}

	@Override
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		if (ex != null) {
			// TODO: need something read-only for a request transporting
			// is not safety transport a request outside from request handling content
			applicationEventPublisher.publishEvent(
					new ReportedExceptionEvent(this, requestIdHolder.getRequestId(), request, ex));
		}
		
		return null; //big hack for further exception normal handling  
	}

}
