package com.example.Spring_TaskManager.repository;

import com.example.Spring_TaskManager.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity,Integer> {
}
