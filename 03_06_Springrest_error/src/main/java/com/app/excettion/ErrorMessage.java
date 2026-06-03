package com.app.excettion;

import java.sql.Date;

public class ErrorMessage {
	private Date timestamp;
	private String message;

	public ErrorMessage(java.util.Date date, String message) {
		this.timestamp = (Date) date;
		this.message = message;
	}

	

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorMessage [timestamp=" + timestamp + ", message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
