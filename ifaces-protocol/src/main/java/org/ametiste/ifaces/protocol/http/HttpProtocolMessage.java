package org.ametiste.ifaces.protocol.http;

import java.util.List;
import java.util.Map;

import org.ametiste.ifaces.protocol.Message;

public class HttpProtocolMessage<T> implements Message {

	private final String method;
	private final String path;
	private final Map<String, List<String>> headers;
	private final Map<String, List<String>> parameters;
	private final T body;

	public HttpProtocolMessage(String method, String path, 
			Map<String, List<String>> headers, Map<String, List<String>> parameters, T body) {
		this.method = method;
		this.path = path;
		this.headers = headers;
		this.parameters = parameters;
		this.body = body;
	}
	
	public String getMethod() {
		return method;
	}
	
	public Map<String, List<String>> getHeaders() {
		return headers;
	}
	
	public Map<String, List<String>> getParameters() {
		return parameters;
	}
	
	public String getPath() {
		return path;
	}
	
	public T getBody() {
		return body;
	}
	
}
