package com.example.demo.exceptions;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		Date date = new java.util.Date();
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		StandardError error = new StandardError(timestamp, "Erro encontrado", "", "", "");
		
		return new ResponseEntity<>(error, status);
	}
}
