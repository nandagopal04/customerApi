package com.chs.customerApi.exception;

public class InvalidOrderIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1222841668518603730L;

	public InvalidOrderIdException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderIdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderIdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
