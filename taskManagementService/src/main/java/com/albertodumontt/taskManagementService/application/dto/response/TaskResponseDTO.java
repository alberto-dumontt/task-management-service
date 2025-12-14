package com.albertodumontt.taskManagementService.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.Instant;

@Data
@Schema(description = "Represents a task returned by the API")
public class TaskResponseDTO {

    @Schema(
            description = "Unique identifier of the task",
            example = "65a8f1b9c2e4f73b8a1c9d12"
    )
    private String id;

    @Schema(
            description = "Task title",
            example = "Finish Spring Boot project"
    )
    private String title;

    @Schema(
            description = "Task detailed description",
            example = "Complete CRUD endpoints and Swagger documentation"
    )
    private String description;

    @Schema(
            description = "Indicates whether the task is completed",
            example = "false"
    )
    private boolean completed;

    @Schema(
            description = "Task creation timestamp in UTC (ISO-8601 format)",
            example = "2025-12-14T18:30:00Z"
    )
    private Instant createdAt;

    @Schema(
            description = "Last update timestamp in UTC (ISO-8601 format)",
            example = "2025-12-15T10:12:45Z"
    )
    private Instant updatedAt;

    @Schema(
            description = "Task expiration date and time in UTC (ISO-8601 format)",
            example = "2026-01-15T18:00:00Z"
    )
    private Instant expiresAt;
}
