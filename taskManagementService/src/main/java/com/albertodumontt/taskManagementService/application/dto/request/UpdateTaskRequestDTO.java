package com.albertodumontt.taskManagementService.application.dto.request;

import lombok.Data;

import java.time.Instant;

@Data
public class UpdateTaskRequestDTO {

    private String title;
    private String description;
    private boolean completed;
    private Instant expiresAt;
}