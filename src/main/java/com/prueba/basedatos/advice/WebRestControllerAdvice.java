package com.prueba.basedatos.advice;

import com.prueba.basedatos.exception.CustomUnexpectedRollbackException;
import com.prueba.basedatos.responses.ResponseMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebRestControllerAdvice {
	
	@ExceptionHandler(CustomUnexpectedRollbackException.class)
	public ResponseMsg handleNotFoundException(CustomUnexpectedRollbackException ex) {
		ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
		return responseMsg;
	}
}
