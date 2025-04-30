package com.example.wheather.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class InvalidMessage extends RuntimeException {
	public  InvalidMessage(String message) {
		super(message);
		
	}

}
