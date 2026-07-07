package com.ifm.ToDoWeb.controller;

import com.ifm.ToDoWeb.entity.TaskEntity;
import com.ifm.ToDoWeb.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<TaskEntity> getTasks(){
        return taskService.showAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Optional<TaskEntity> getTaskById(@PathVariable Long id){
        return taskService.showTask(id);
    }

    @PostMapping("/task")
    public TaskEntity createTask(@RequestBody TaskEntity task){
        return taskService.createTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
