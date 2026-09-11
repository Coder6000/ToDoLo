package com.ifm.ToDoWeb.service;

import com.ifm.ToDoWeb.dto.TaskDTO;
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

    public List<TaskDTO> showAllTasks(){
        return taskRepository.findAll().stream().map(this::entityToDTO).toList();
    }

     
    public TaskDTO showTask(Long taskID){
        TaskEntity taskEntity = taskRepository.findById(taskID).orElse(null);
        return new TaskDTO(taskEntity.getId(), taskEntity.getTask());
    }

    public TaskDTO createTask(TaskDTO task){
        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setTask(task.getTask());

        if(task.getTask().isBlank()){
            throw new RuntimeException();
        }
        TaskEntity newTask = taskRepository.save(taskEntity);
        return entityToDTO(newTask);
    }

    public void deleteTask(Long taskID){
        taskRepository.deleteById(taskID);
    }

    private TaskDTO entityToDTO(TaskEntity task){
        return new TaskDTO(task.getId(),  task.getTask());
    }
}