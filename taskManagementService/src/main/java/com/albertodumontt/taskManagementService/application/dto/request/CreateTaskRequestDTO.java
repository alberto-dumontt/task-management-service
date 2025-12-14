package com.albertodumontt.taskManagementService.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.Instant;

@Schema(description = "Request payload to create a task")
@Data
public class CreateTaskRequestDTO {
    @Schema(
            description = "Task title",
            example = "Study Spring Boot"
    )
    private String title;

    @Schema(
            description = "Detailed description of the task",
            example = "Study Swagger, MongoDB integration and DTO validation"
    )
    private String description;

    @Schema(
            description = "Task expiration date and time in UTC (ISO-8601 format)",
            example = "2025-12-31T23:59:59Z"
    )
    private Instant expiresAt;
}
