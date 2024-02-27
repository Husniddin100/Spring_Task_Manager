package com.example.Spring_TaskManager.service;

import com.example.Spring_TaskManager.dto.TaskDTO;
import com.example.Spring_TaskManager.entity.TaskEntity;
import com.example.Spring_TaskManager.enums.TaskStatus;
import com.example.Spring_TaskManager.exp.AppBadException;
import com.example.Spring_TaskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskDTO createTask(TaskDTO dto) {
        TaskEntity entity = new TaskEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setTaskStatus(TaskStatus.ACTIVE);
        entity.setCreated_date(LocalDateTime.now());
        taskRepository.save(entity);

        dto.setId(entity.getId());
        dto.setCreated_date(entity.getCreated_date());
        return dto;
    }

    public List<TaskDTO> getList() {
        Iterable<TaskEntity> list = taskRepository.findAll();
        List<TaskDTO> dtoList = new LinkedList<>();
        for (TaskEntity entity : list) {
            if (entity.getTaskStatus().equals(TaskStatus.ACTIVE)) {
                dtoList.add(toDTO(entity));
            }
        }
        return dtoList;
    }

    public List<TaskDTO> getCompletedTaskList() {
        Iterable<TaskEntity> list = taskRepository.findAll();
        List<TaskDTO> dtoList = new LinkedList<>();
        for (TaskEntity entity : list) {
            if (entity.getTaskStatus().equals(TaskStatus.COMPLETED)) {
                dtoList.add(toDTO(entity));
            }
        }
        return dtoList;
    }

    public TaskDTO toDTO(TaskEntity entity) {
        TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setTaskStatus(entity.getTaskStatus());
        dto.setCreated_date(entity.getCreated_date());
        dto.setFinished_date(entity.getFinished_date());
        return dto;
    }

    public Boolean completedTask(Integer id) {
        Optional<TaskEntity> optional = taskRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadException("task not found");
        }
        TaskEntity entity = optional.get();
        if (entity.getTaskStatus().equals(TaskStatus.COMPLETED)) {
            throw new AppBadException("task already completed");
        }
        entity.setTaskStatus(TaskStatus.COMPLETED);
        entity.setFinished_date(LocalDateTime.now());
        taskRepository.save(entity);
        return true;
    }

    public TaskDTO getById(Integer id) {
        Optional<TaskEntity>optional=taskRepository.findById(id);
        TaskEntity entity=optional.get();
        TaskDTO dto=new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setTaskStatus(entity.getTaskStatus());
        dto.setCreated_date(entity.getCreated_date());
        dto.setFinished_date(entity.getFinished_date());
        return dto;
    }
}
