package com.albertodumontt.taskManagementService.application.dto.response;

import lombok.Data;

import java.time.Instant;

@Data
public class TaskResponseDTO {

    private String id;
    private String title;
    private String description;
    private boolean completed;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant expiresAt;
}
