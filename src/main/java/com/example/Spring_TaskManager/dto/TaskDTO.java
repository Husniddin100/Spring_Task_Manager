package com.example.Spring_TaskManager.dto;

import com.example.Spring_TaskManager.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {
    private int id;
    private String title;
    private String content;
    private TaskStatus taskStatus;
    private LocalDateTime created_date;
    private LocalDateTime finished_date;

}
