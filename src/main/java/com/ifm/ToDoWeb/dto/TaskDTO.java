package com.ifm.ToDoWeb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TaskDTO {
    private Long id;
    private String task;

    public TaskDTO(Long id, String task) {
        this.id = id;
        this.task = task;
    }
}
