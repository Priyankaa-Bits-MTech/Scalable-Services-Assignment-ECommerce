package com.ecommerce.users.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserServiceExceptionHandler extends ResponseEntityExceptionHandler{
 
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<GenericError> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
	
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		String message = ex.getMessage();
		if(ex instanceof AccessDeniedException) {
			status = HttpStatus.FORBIDDEN;
			message = "You do not have enough rights to access the API";
		}
		if(ex instanceof BadCredentialsException) {
			status = HttpStatus.UNAUTHORIZED;
			message = "Invalid username or password";
		}
		
		GenericError errorDetails = new GenericError(
				message, request.getDescription(false));
		
		return new ResponseEntity<GenericError>(errorDetails, status);
		
	}

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		FieldErrors errorDetails = new FieldErrors(
				errors, request.getDescription(false));
		
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);		
	
	}
 
	
}