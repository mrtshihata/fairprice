package com.minute.rest.webservices.restfullwebservices.exception;

import java.util.Date;

/**
 * @author gtshihata
 *
 */
public class ExceptionResponse {
	
	private Date timestamp;
	private String message;
	private String detail;
	

	public ExceptionResponse(Date timestamp, String message, String detail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}


	public String getMessage() {
		return message;
	}


	public String getDetail() {
		return detail;
	}



}
