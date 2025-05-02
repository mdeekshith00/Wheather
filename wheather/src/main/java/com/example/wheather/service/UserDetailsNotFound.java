package com.example.wheather.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code=HttpStatus.NO_CONTENT)
public class UserDetailsNotFound extends RuntimeException {
	public UserDetailsNotFound(String message) {
		super(message);
	}

}
