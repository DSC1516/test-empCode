package com.rest.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rest.api.exception.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	public ResponseEntity<ApiResponse> handlerResourseNotFoundException(Exception ex){
		String message=ex.getMessage();	
		ApiResponse response=ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
}
