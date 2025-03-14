package dev.joordih.prozen.services.impl;

import dev.joordih.prozen.managers.models.impl.task.Task;
import dev.joordih.prozen.managers.models.impl.task.TaskRepository;
import dev.joordih.prozen.services.TaskService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

/*
 *
 *  * Copyright 2025 Jordi Xavier
 *  *
 *  * Class: TaskServiceImpl
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:34:22
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

@Singleton
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Inject
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findByAssignee(ObjectId assigneeId) {
        return taskRepository.findByAssignee(assigneeId);
    }

    @Override
    public List<Task> findByType(Task.TaskType type) {
        return taskRepository.findByType(type);
    }

    @Override
    public List<Task> findByStatus(Task.TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public Task create(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.create(task);
    }

    @Override
    public Task update(String id, Task task) {
        task.setId(id);
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.update(id, task);
    }

    @Override
    public void delete(String id) {
        taskRepository.delete(id);
    }
}
