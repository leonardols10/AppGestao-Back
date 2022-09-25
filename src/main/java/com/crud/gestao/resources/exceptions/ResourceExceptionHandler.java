package com.crud.gestao.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crud.gestao.services.exceptions.ObjectnotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	//formata os dados do retorno de obj não encontrado
	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandardError> objectnotFoundException(ObjectnotFoundException ex, 
			HttpServletRequest request) 	{
		
		StandardError	error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), 
				"Object not found", ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
