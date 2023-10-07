package com.example.demo.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5328007144691249149L;

	public ResourceNotFoundException(String message) {
		super("Erro encontrado!");
		// TODO Auto-generated constructor stub
	}
}
