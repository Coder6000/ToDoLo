package com.ifm.ToDoWeb.repository;

import com.ifm.ToDoWeb.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}