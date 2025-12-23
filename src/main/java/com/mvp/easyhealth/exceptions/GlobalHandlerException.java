package com.mvp.easyhealth.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalHandlerException {
	
	
	@ExceptionHandler(PessoaInexistenteException.class)
	public ResponseEntity<Map<String, Object>> handlerExceptionPessoaInexistenteException(PessoaInexistenteException ex, HttpServletRequest req)
	{
		Map<String, Object> body = Map.of(
				
				"error", ex.getMessage(),
				"status", 404
				
				);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handlerExceptionDefault(Exception ex, HttpServletRequest req)
	{
		Map<String, Object> body = Map.of(
				
				"error", ex.getMessage(),
				"status", 500
				
				);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
	}

}
