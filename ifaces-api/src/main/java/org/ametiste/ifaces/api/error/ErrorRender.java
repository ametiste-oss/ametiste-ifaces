package org.ametiste.ifaces.api.error;

/**
 * pure DTO, used only for data transfer
 * 
 * 
 * @author Daria
 * 
 */
public class ErrorRender {


	public final String code;
	public final String message;
	public final String request_id;

	public ErrorRender(String code, String message, String request_id) {
		this.code = code;
		this.message = message;
		this.request_id = request_id;

	}

}
