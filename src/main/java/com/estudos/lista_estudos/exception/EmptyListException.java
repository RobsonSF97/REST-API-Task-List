package com.estudos.lista_estudos.exception;

public class EmptyListException extends RuntimeException{
	
	public EmptyListException() {
		super("There is no item in your list.");
	}

}
