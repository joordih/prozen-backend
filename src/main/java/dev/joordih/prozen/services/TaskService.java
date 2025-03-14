package dev.joordih.prozen.services;

import dev.joordih.prozen.managers.models.impl.task.Task;
import org.bson.types.ObjectId;

import java.util.List;

/*
 *
 *  * Copyright © 2025 Jordi Xavier
 *  *
 *  * Class: TaskService
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:34:22
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

public interface TaskService {
    List<Task> findAll();
    List<Task> findByAssignee(ObjectId assigneeId);
    List<Task> findByType(Task.TaskType type);
    List<Task> findByStatus(Task.TaskStatus status);
    Task create(Task task);
    Task update(String id, Task task);
    void delete(String id);
}
