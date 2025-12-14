package com.albertodumontt.taskManagementService.application.service;

import com.albertodumontt.taskManagementService.application.dto.request.CreateTaskRequestDTO;
import com.albertodumontt.taskManagementService.application.dto.request.UpdateTaskRequestDTO;
import com.albertodumontt.taskManagementService.application.dto.response.TaskResponseDTO;
import com.albertodumontt.taskManagementService.domain.model.Task;
import com.albertodumontt.taskManagementService.domain.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponseDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TaskResponseDTO getTask(String id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return toResponse(task);
    }

    public TaskResponseDTO createTask(CreateTaskRequestDTO request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setExpiresAt(request.getExpiresAt());
        task.setCompleted(false);
        task.setCreatedAt(Instant.now());
        task.setUpdatedAt(Instant.now());

        Task saved = taskRepository.save(task);

        return toResponse(saved);
    }

    public TaskResponseDTO update(String id, UpdateTaskRequestDTO request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());
        task.setExpiresAt(request.getExpiresAt());
        task.setUpdatedAt(Instant.now());

        Task saved = taskRepository.save(task);

        return toResponse(saved);
    }

    public void deleteById(String id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }

    private TaskResponseDTO toResponse(Task task) {
        TaskResponseDTO response = new TaskResponseDTO();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setCompleted(task.isCompleted());
        response.setCreatedAt(task.getCreatedAt());
        response.setUpdatedAt(task.getUpdatedAt());
        response.setExpiresAt(task.getExpiresAt());
        return response;
    }
}
