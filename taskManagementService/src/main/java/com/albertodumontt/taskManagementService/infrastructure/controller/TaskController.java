package com.albertodumontt.taskManagementService.infrastructure.controller;

import com.albertodumontt.taskManagementService.application.dto.request.CreateTaskRequestDTO;
import com.albertodumontt.taskManagementService.application.dto.request.UpdateTaskRequestDTO;
import com.albertodumontt.taskManagementService.application.dto.response.TaskResponseDTO;
import com.albertodumontt.taskManagementService.application.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskResponseDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTask(
            @PathVariable String id
    ) {
        TaskResponseDTO task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("create")
    public ResponseEntity<TaskResponseDTO> create(
            @RequestBody CreateTaskRequestDTO request
    ) {
        return ResponseEntity.ok(taskService.createTask(request));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<TaskResponseDTO> update(
            @PathVariable String id,
            @RequestBody UpdateTaskRequestDTO request
    ) {
        return ResponseEntity.ok(taskService.update(id, request));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
