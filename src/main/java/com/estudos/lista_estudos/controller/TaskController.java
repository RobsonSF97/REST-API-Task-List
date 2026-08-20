package com.estudos.lista_estudos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.lista_estudos.dto.TaskRequestDTO;
import com.estudos.lista_estudos.dto.TaskResponseDTO;
import com.estudos.lista_estudos.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService service) {
		this.taskService = service;
	}
	

	@PostMapping("/create")
	public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO taskRequest) {
		TaskResponseDTO response = taskService.createTask(taskRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<TaskResponseDTO>> listAll(){
		List <TaskResponseDTO> response = taskService.findAllTasks();
		
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<TaskResponseDTO> findById(@PathVariable("id") Long id){
		TaskResponseDTO response = taskService.findTaskById(id);
		
		return ResponseEntity.ok(response);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteTaskById(@PathVariable("id") Long id) {
		taskService.deleteTaskById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("The task was successfully deleted");
	}
	
	@PatchMapping("/complete/{id}")
	public ResponseEntity<TaskResponseDTO> completeTask(@PathVariable("id") Long id) {
		TaskResponseDTO response =  taskService.completeTask(id);
		
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Object> updateTask(@PathVariable("id") Long id, @Valid @RequestBody TaskRequestDTO taskRequest){
		TaskResponseDTO response = taskService.updateTask(id, taskRequest);
		
		return ResponseEntity.ok(response);
	}
	
}
