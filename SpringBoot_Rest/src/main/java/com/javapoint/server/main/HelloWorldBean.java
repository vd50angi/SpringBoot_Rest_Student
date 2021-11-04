package com.javapoint.server.main;

public class HelloWorldBean {
	
	public String message;
	//constructor of HelloWorldBean

	public HelloWorldBean(String message) {
		

	
	{
		this.message=message;
	}
	
	//generate setters and getters
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	//generate toString
	
	
	
	
	

}
