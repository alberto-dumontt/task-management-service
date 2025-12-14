package com.albertodumontt.taskManagementService.infrastructure.controller;

import com.albertodumontt.taskManagementService.application.dto.request.CreateTaskRequestDTO;
import com.albertodumontt.taskManagementService.application.dto.request.UpdateTaskRequestDTO;
import com.albertodumontt.taskManagementService.application.dto.response.TaskResponseDTO;
import com.albertodumontt.taskManagementService.application.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Tasks",
        description = "Endpoints for managing tasks"
)
@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(
            summary = "Get all tasks",
            description = "Retrieves a list of all tasks"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tasks retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskResponseDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @Operation(
            summary = "Get all tasks",
            description = "Retrieves a list of all tasks"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tasks retrieved successfully")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTask(
            @PathVariable String id
    ) {
        TaskResponseDTO task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }


    @Operation(
            summary = "Create a new task",
            description = "Creates a new task with title, description and expiration date"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Task created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping("create")
    public ResponseEntity<TaskResponseDTO> create(
            @RequestBody CreateTaskRequestDTO request
    ) {
        return ResponseEntity.ok(taskService.createTask(request));
    }

    @Operation(
            summary = "Update an existing task",
            description = "Updates the title, description, expiration date or completion status of a task"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Task updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @PutMapping("update/{id}")
    public ResponseEntity<TaskResponseDTO> update(
            @PathVariable String id,
            @RequestBody UpdateTaskRequestDTO request
    ) {
        return ResponseEntity.ok(taskService.update(id, request));
    }

    @Operation(
            summary = "Delete a task",
            description = "Deletes a task by its unique identifier"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Task deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
