package com.StoreCounterSystem.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.StoreCounterSystem.exception.IdNotFoundException;

@RestControllerAdvice
public class ExceptionController {
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public Map<String, String> handleIdNotFoundException(IdNotFoundException ex){
		Map<String, String> errors =  new HashMap<String, String>();	
		errors.put("message",ex.getMessage());
		return errors;
	}
}
