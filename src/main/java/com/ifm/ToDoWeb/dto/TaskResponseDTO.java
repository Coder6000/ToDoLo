package com.ifm.ToDoWeb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class TaskResponseDTO {
    private Long id;
    private String task;

}
