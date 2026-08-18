package com.estudos.lista_estudos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.estudos.lista_estudos.entity.TaskEntity;
import com.estudos.lista_estudos.exception.DuplicateTitleException;
import com.estudos.lista_estudos.exception.EmptyTitleException;
import com.estudos.lista_estudos.exception.TaskNotFoundException;
import com.estudos.lista_estudos.repository.TaskRepository;


@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository repository) {
		this.taskRepository = repository;
	}
	
	
	public List<TaskEntity> findAllTasks() {
		return taskRepository.findAll();
	}
	
	public TaskEntity findTaskById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
	}
	
	@Transactional
	public void createTask(TaskEntity task) {
		if (task.getTitle().isBlank()) {
			throw new EmptyTitleException();
		}
		
		if (taskRepository.existsByTitleIgnoreCase(task.getTitle())) {
			throw new DuplicateTitleException(task.getTitle());
		}

		task.setCompleted(false);
		task.setCreatedAt(LocalDateTime.now());
		taskRepository.save(task);
	}
	
	@Transactional
	public void deleteTaskById(Long id) {
		if (!taskRepository.existsById(id)) {
			throw new TaskNotFoundException(id);
		}
		taskRepository.deleteById(id);
	}

}
