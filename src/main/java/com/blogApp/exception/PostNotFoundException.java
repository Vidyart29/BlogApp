package com.blogApp.exception;

public class PostNotFoundException extends RuntimeException{
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -7182905945314218841L;
	public PostNotFoundException() {
		super();
	}

	public PostNotFoundException(String message) {
		super(message);
	}
}
