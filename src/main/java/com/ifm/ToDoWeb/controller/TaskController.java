package com.ifm.ToDoWeb.controller;

import com.ifm.ToDoWeb.dto.TaskRequestDTO;
import com.ifm.ToDoWeb.dto.TaskResponseDTO;
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
    public List<TaskResponseDTO> getTasks(){
        return taskService.showAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id){
        return taskService.showTask(id);
    }

    @PostMapping("/tasks")
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO request){
        return taskService.createTask(request);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @DeleteMapping("/tasks/all")
    public void deleteAllTasks(){
        taskService.deleteAllTasks();
    }
}
