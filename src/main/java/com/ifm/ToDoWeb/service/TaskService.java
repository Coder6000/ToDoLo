package com.ifm.ToDoWeb.service;

import com.ifm.ToDoWeb.entity.TaskEntity;
import com.ifm.ToDoWeb.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> showAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> showTask(Long taskID){
        return taskRepository.findById(taskID);
    }

    public TaskEntity createTask(TaskEntity task){
        if(task.getTask().isBlank()){
            throw new RuntimeException();
        }
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskID){
        taskRepository.deleteById(taskID);
    }
}