package com.cogent.controller;

import java.sql.Date;

public class ErrorDetails {
	    private Date timestamp;
	    private String message;
	    private String details;

	    public ErrorDetails(java.util.Date date, String message, String details) {

	

}
	    public ErrorDetails()
	    {
	    	
	    }

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}
}