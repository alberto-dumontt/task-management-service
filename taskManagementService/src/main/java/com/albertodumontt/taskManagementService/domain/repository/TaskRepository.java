package com.albertodumontt.taskManagementService.domain.repository;

import com.albertodumontt.taskManagementService.domain.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
