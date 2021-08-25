package com.prueba.basedatos.exception;

import org.springframework.transaction.UnexpectedRollbackException;

public class CustomUnexpectedRollbackException extends UnexpectedRollbackException {

	public CustomUnexpectedRollbackException(String msg) {
		super(msg);
	}
}
