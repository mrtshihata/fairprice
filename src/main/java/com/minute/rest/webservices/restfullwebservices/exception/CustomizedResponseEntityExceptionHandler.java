package com.minute.rest.webservices.restfullwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.minute.rest.webservices.restfullwebservices.user.UserNotFoundException;

/**
 * @author gtshihata
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		
		ExceptionResponse ExceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), 
						request.getDescription(false));
	
	 return  new ResponseEntity(ExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> UserNotFoundException(UserNotFoundException ex, WebRequest request){
		
		ExceptionResponse ExceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), 
						request.getDescription(false));
	
	 return  new ResponseEntity(ExceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       
		ExceptionResponse ExceptionResponse = 
				new ExceptionResponse(new Date(), "Validation Fail", 
						ex.getBindingResult().toString());
		 return  new ResponseEntity(ExceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
