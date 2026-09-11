package com.ifm.ToDoWeb.controller;

import com.ifm.ToDoWeb.dto.TaskDTO;
import com.ifm.ToDoWeb.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<TaskDTO> getTasks(){
        return taskService.showAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public TaskDTO getTaskById(@PathVariable Long id){
        return taskService.showTask(id);
    }

    @PostMapping("/tasks")
    public TaskDTO createTask(@RequestBody TaskDTO task){
        return taskService.createTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
