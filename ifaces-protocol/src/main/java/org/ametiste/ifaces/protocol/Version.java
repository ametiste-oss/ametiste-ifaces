package org.ametiste.ifaces.protocol;

public class Version implements ProtocolFeature {

	private final String generation;
	
	private final String major;
	
	private final String minor;
	
	private final String qualifier;

	public Version(String generation, String major, String minor, String qualifier) {
		this.generation = generation;
		this.major = major;
		this.minor = minor;
		this.qualifier = qualifier;
	}
	
	@Override
	public boolean match(ProtocolFeature feature) {
		
		
		
		return false;
	}

}
