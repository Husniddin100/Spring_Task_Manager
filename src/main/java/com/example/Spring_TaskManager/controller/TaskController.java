package com.example.Spring_TaskManager.controller;

import com.example.Spring_TaskManager.dto.TaskDTO;
import com.example.Spring_TaskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("/task_list")
    public ResponseEntity<List<TaskDTO>> getList() {
        List<TaskDTO> list = taskService.getList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/completed_task_list")
    public ResponseEntity<List<TaskDTO>> getCompletedTaskList() {
        List<TaskDTO> list = taskService.getCompletedTaskList();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/completedTask/{id}")
    public ResponseEntity<Boolean> completedTask(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.completedTask(id));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TaskDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.getById(id));
    }
}
