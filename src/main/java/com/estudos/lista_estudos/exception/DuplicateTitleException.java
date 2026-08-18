package com.estudos.lista_estudos.exception;

public class DuplicateTitleException extends RuntimeException {
	
	public DuplicateTitleException(String title) {
		super("Task with title already exists: " + title);
	}

}
