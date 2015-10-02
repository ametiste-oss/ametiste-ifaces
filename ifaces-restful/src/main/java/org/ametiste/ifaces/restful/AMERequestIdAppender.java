package org.ametiste.ifaces.restful;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AMERequestIdAppender extends HandlerInterceptorAdapter {

	public static final String HEADER_NAME = "Ame-Request-Id";
	
	private RequestIdHolder requestIdHolder;

	public void setRequestIdHolder(RequestIdHolder requestIdHolder) {
		this.requestIdHolder = requestIdHolder;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		// TODO: try setHeader there
		response.addHeader(HEADER_NAME, 
				requestIdHolder.getRequestId().toString());
		
		return true;
	}
	
}
