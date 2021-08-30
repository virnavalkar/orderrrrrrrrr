package com.main.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class WrongPaymentMethodException extends Exception {

	
	public WrongPaymentMethodException(String msg) {
		super(msg);
	
}
}