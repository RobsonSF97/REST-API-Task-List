package com.estudos.lista_estudos.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.estudos.lista_estudos.dto.TaskRequestDTO;
import com.estudos.lista_estudos.dto.TaskResponseDTO;
import com.estudos.lista_estudos.dto.mapper.TaskMapper;
import com.estudos.lista_estudos.entity.TaskEntity;
import com.estudos.lista_estudos.exception.DuplicateTitleException;
import com.estudos.lista_estudos.exception.EmptyListException;
import com.estudos.lista_estudos.exception.EmptyTitleException;
import com.estudos.lista_estudos.exception.TaskNotFoundException;
import com.estudos.lista_estudos.repository.TaskRepository;


@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	private final TaskMapper taskMapper;

	public TaskService(TaskRepository repository, TaskMapper mapper) {
		this.taskRepository = repository;
		this.taskMapper = mapper;
	}
	
	public List<TaskResponseDTO> findAllTasks() {
		List<TaskEntity> listEntity = taskRepository.findAll();
		List<TaskResponseDTO> response = new ArrayList<>();
		if (listEntity == null || listEntity.isEmpty()) {
			throw new EmptyListException();
		}
		for (TaskEntity item : listEntity) {
			TaskResponseDTO dto = taskMapper.entityToDTO(item);
			response.add(dto);
		}
		return response;
	}
	
	public TaskResponseDTO findTaskById(Long id) {
		TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
		return taskMapper.entityToDTO(taskEntity);
	}
	
	@Transactional
	public TaskResponseDTO createTask(TaskRequestDTO request) {
		validRequestCreateTask(request);
		TaskEntity taskEntity = taskMapper.dtoToEntity(request);
		taskEntity.setCompleted(false);
		taskEntity.setCreatedAt(LocalDateTime.now());
		taskRepository.save(taskEntity);
		return taskMapper.entityToDTO(taskEntity);
	}

	@Transactional
	public void deleteTaskById(Long id) {
		taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
		
		taskRepository.deleteById(id);
	}
	
	@Transactional
	public TaskResponseDTO completeTask(Long id) {
		TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
		taskEntity.setCompleted(true);
		taskRepository.save(taskEntity);
		return taskMapper.entityToDTO(taskEntity);
	}
	
	@Transactional
	public TaskResponseDTO updateTask(Long id, TaskRequestDTO request) {
		TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
		
		if(!(request.getDescription() == null || request.getDescription().isBlank())) {
		taskEntity.setDescription(request.getDescription());
		}
		
		if(!(request.getTitle() == null || request.getTitle().isBlank())) {
			taskEntity.setTitle(request.getTitle());
		}
		taskRepository.save(taskEntity);
		return taskMapper.entityToDTO(taskEntity);
		
	}
	
	
	private void validRequestCreateTask(TaskRequestDTO request) {
		if (request.getTitle().isBlank()) {
			throw new EmptyTitleException();
		}

		if (taskRepository.existsByTitleIgnoreCase(request.getTitle())) {
			throw new DuplicateTitleException(request.getTitle());
		}
		
	}

}
