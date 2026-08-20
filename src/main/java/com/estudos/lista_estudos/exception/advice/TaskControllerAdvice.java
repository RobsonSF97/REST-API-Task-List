package com.estudos.lista_estudos.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudos.lista_estudos.exception.DuplicateTitleException;
import com.estudos.lista_estudos.exception.EmptyTitleException;
import com.estudos.lista_estudos.exception.TaskNotFoundException;

@ControllerAdvice
public class TaskControllerAdvice {
	
	@ExceptionHandler(EmptyTitleException.class)
	public ResponseEntity<String> handleEmptyTitle(EmptyTitleException ex){
		return ResponseEntity.badRequest().body("Title of the Task cannot be empty");
	}
	
    @ExceptionHandler(DuplicateTitleException.class)
    public ResponseEntity<String> handleDuplicateTitle(DuplicateTitleException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            "Already exist a task using this title.");
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleTaskNotFound(TaskNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }

}
