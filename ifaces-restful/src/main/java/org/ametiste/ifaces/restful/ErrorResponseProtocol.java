package org.ametiste.ifaces.restful;

public enum ErrorResponseProtocol {

	CODE_FIELD("code");
	
	private final String fieldName;

	ErrorResponseProtocol(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
}
