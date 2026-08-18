package com.estudos.lista_estudos.exception;

public class EmptyTitleException extends RuntimeException {
	
	public EmptyTitleException() {
		super("Task Title must not be blank");
	}

}
