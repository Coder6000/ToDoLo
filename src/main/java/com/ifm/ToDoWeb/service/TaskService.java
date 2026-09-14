package com.ifm.ToDoWeb.service;

import com.ifm.ToDoWeb.dto.TaskRequestDTO;
import com.ifm.ToDoWeb.dto.TaskResponseDTO;
import com.ifm.ToDoWeb.entity.TaskEntity;
import com.ifm.ToDoWeb.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<TaskResponseDTO> showAllTasks(){
        return taskRepository.findAll().stream().map(this::entityToDTO).toList();
    }

     
    public TaskResponseDTO showTask(Long taskID){
        TaskEntity taskEntity = taskRepository.findById(taskID).orElse(null);
        return new TaskResponseDTO(taskEntity.getId(), taskEntity.getTask());
    }

    public TaskResponseDTO createTask(TaskRequestDTO request){
        TaskEntity taskEntity = new TaskEntity();

        if(request.getTask().isBlank()){
            throw new RuntimeException();
        }

        taskEntity.setTask(request.getTask());

        TaskEntity newTask = taskRepository.save(taskEntity);
        return entityToDTO(newTask);
    }

    public void deleteTask(Long taskID){
        taskRepository.deleteById(taskID);
    }

    public void deleteAllTasks(){
        taskRepository.deleteAll();
    }

    private TaskResponseDTO entityToDTO(TaskEntity task){
        return new TaskResponseDTO(task.getId(),  task.getTask());
    }
}