package org.ametiste.ifaces.protocol;

public interface Protocol<F, T> {

	T buildMessage(F message);
	
	// boolean isSupports(ProtocolFeature protocolFeature);
	
}
