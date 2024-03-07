package com.example.Spring_TaskManager.repository;

import com.example.Spring_TaskManager.entity.TaskEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {
    @Query("from TaskEntity where  created_date=?1")
    Iterable<TaskEntity> getAll(LocalDateTime date);
}
