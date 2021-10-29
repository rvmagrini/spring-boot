package com.rvmagrini.springboot.exception;

public class DepartmentNotFoundException extends Exception {

	private static final long serialVersionUID = -2031396433470442424L;

	public DepartmentNotFoundException() {
		super();
	}

	public DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DepartmentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentNotFoundException(String message) {
		super(message);
	}

	public DepartmentNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
	
}
