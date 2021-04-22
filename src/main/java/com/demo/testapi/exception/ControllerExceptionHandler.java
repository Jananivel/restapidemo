package com.demo.testapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.demo.testapi.model.ExceptionDetails;

@ControllerAdvice
public class ControllerExceptionHandler {

	 @ExceptionHandler(RecordNotFoundException.class)
	  public ResponseEntity<ExceptionDetails> resourceNotFoundException(RecordNotFoundException ex, WebRequest request) {
		 ExceptionDetails message = new ExceptionDetails(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ExceptionDetails>(message, HttpStatus.NOT_FOUND);
	  }

	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<ExceptionDetails> globalExceptionHandler(Exception ex, WebRequest request) {
		  ExceptionDetails message = new ExceptionDetails(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ExceptionDetails>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
