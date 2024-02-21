package com.example.Spring_TaskManager.controller;

import com.example.Spring_TaskManager.dto.TaskDTO;
import com.example.Spring_TaskManager.service.TaskService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO dto) {
        return ResponseEntity.ok(taskService.createTask(dto));
    }

    @GetMapping("/tasklist")
    public ResponseEntity<List<TaskDTO>> getList() {
        List<TaskDTO> list = taskService.getList();
        return ResponseEntity.ok(list);
    }
}
