package com.albertodumontt.taskManagementService.application.dto.request;

import lombok.Data;

import java.time.Instant;

@Data
public class CreateTaskRequestDTO {
    private String title;
    private String description;
    private Instant expiresAt;
}
