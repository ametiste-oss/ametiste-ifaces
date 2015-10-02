package org.ametiste.ifaces.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.Assert;

public class StrictContextMatcher implements ContextMatcher, InitializingBean {

	private String rootContextId;
	private String contextId;
	private String applicationContext;

	@Override
	public boolean match(ContextRefreshedEvent event) {
		return event.getApplicationContext().getId().equals(applicationContext);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.hasText(contextId, "Context name cant be empty");
		Assert.hasText(rootContextId, "Root context name cant be empty");
		applicationContext = rootContextId + contextId;

	}

	public void setContextId(String contextId) {
		this.contextId = contextId;
	}

	public void setRootContextId(String rootContextId) {
		this.rootContextId = rootContextId;
	}

}
