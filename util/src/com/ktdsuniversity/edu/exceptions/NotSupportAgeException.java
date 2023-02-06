package com.ktdsuniversity.edu.exceptions;

public class NotSupportAgeException extends RuntimeException {

	private static final long serialVersionUID = -3071941030476310489L;
	
	public NotSupportAgeException() {
		super();
	}
	
	public NotSupportAgeException (String message) {
		super (message);
	}

}
