package com.chs.customerApi.exception;

public class InvalidCustomerIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7981734933430982220L;

	public InvalidCustomerIdException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidCustomerIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCustomerIdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCustomerIdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCustomerIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
