package com.estudos.lista_estudos.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskResponseDTO {
	
	private Long id;
	
	private String title;
	
	private String description;
	
	private boolean completed;
	
	private LocalDateTime createdAt;
	
}
