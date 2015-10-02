package org.ametiste.ifaces.spring;

import org.springframework.context.event.ContextRefreshedEvent;

public interface ContextMatcher {
	
	boolean match(ContextRefreshedEvent event);

}
