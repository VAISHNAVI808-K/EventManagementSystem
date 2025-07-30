package com.eventManagement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.eventManagement.dto.ExceptionResponse;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	ExceptionResponse resourceNotFoundException(ResourceNotFoundException ex) {

		ExceptionResponse response = new ExceptionResponse();
		response.setMsg(ex.getMessage());
		response.setStatusCode(HttpStatus.BAD_REQUEST);
		response.setDate(LocalDateTime.now());
		return response;
	}
}
