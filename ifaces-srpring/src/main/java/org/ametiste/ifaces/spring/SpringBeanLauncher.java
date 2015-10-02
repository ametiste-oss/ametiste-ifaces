package org.ametiste.ifaces.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.Assert;

public class SpringBeanLauncher implements ApplicationListener<ContextRefreshedEvent>, InitializingBean {

	private Launchable launchableBean;
	private ContextMatcher matcher;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (matcher.match(event)) {
			launchableBean.launch();
		}
	}


	public void setLaunchableBean(Launchable launchableBean) {
		this.launchableBean = launchableBean;
	}

	public void setMatcher(ContextMatcher matcher) {
		this.matcher = matcher;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(launchableBean, "Bean to launch should be defined, cant be null");
		Assert.notNull(matcher, "Matcher shouldnt be null");

	}

}
