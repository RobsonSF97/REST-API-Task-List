package com.estudos.lista_estudos.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO {
	
	private String title;
	
	@Size(max = 300)
	private String description;

}
