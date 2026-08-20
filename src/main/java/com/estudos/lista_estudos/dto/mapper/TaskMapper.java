package com.estudos.lista_estudos.dto.mapper;

import org.springframework.stereotype.Component;

import com.estudos.lista_estudos.dto.TaskRequestDTO;
import com.estudos.lista_estudos.dto.TaskResponseDTO;
import com.estudos.lista_estudos.entity.TaskEntity;

@Component
public class TaskMapper {
	
	public TaskEntity dtoToEntity(TaskRequestDTO dto) {
		TaskEntity entity = new TaskEntity();
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		
		return entity;
		
	}
	
	public TaskResponseDTO entityToDTO(TaskEntity entity) {
		TaskResponseDTO dto = new TaskResponseDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setCompleted(entity.isCompleted());
		dto.setCreatedAt(entity.getCreatedAt());
		return dto;
	}

}
