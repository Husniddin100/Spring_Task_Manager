package com.example.Spring_TaskManager.service;

import com.example.Spring_TaskManager.dto.TaskDTO;
import com.example.Spring_TaskManager.entity.TaskEntity;
import com.example.Spring_TaskManager.enums.TaskStatus;
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
        List<TaskDTO>dtoList=new LinkedList<>();
        for (TaskEntity entity:list){
            if(entity.getTaskStatus().equals(TaskStatus.ACTIVE)){
                dtoList.add(toDTO(entity));
            }
        }
        return dtoList;
    }

    public TaskDTO toDTO(TaskEntity entity) {
        TaskDTO dto = new TaskDTO();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setTaskStatus(entity.getTaskStatus());
        dto.setCreated_date(entity.getCreated_date());
        dto.setFinished_date(entity.getFinished_date());
        return dto;
    }
}
