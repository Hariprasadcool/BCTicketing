package com.hp.bc.tickets.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class TicketsNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TicketsNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
