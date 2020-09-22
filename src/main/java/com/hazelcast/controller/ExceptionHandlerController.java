package com.hazelcast.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hazelcast.enumarations.ExceptionEnum;
import com.hazelcast.exception.ErrorResponseException;
import com.hazelcast.exception.Response;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(ErrorResponseException.class)
	public ResponseEntity<Response> errorResponseExceptionHandler(ErrorResponseException ex) {
		return new ResponseEntity<>(ex.getResponse(), ex.getStatus());
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Response> nullPointerException(NullPointerException ex) {
		return new ResponseEntity<>(
				Response.builder()
						.code(ExceptionEnum.INTERNAL_SERVER_ERROR.getId())
						.description(ExceptionEnum.INTERNAL_SERVER_ERROR.getDescription())
						.message(ex.getMessage())
						.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
