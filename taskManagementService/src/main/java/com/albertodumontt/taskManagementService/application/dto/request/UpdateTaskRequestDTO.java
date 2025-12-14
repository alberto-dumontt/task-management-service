package com.albertodumontt.taskManagementService.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.Instant;

@Data
@Schema(description = "Request payload used to update an existing task")
public class UpdateTaskRequestDTO {

    @Schema(
            description = "Updated task title",
            example = "Finish Spring Boot project"
    )
    private String title;

    @Schema(
            description = "Updated task description",
            example = "Complete endpoints, Swagger documentation and MongoDB integration"
    )
    private String description;

    @Schema(
            description = "Indicates whether the task is completed",
            example = "true"
    )
    private boolean completed;

    @Schema(
            description = "Updated task expiration date and time in UTC (ISO-8601 format)",
            example = "2026-01-15T18:00:00Z"
    )
    private Instant expiresAt;
}