package org.ametiste.ifaces.api.error;

public interface ErrorView {

	void addCode(String code);

	void addMessage(String message);

	boolean allowsUpdate();

}
