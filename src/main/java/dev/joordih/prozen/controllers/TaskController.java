package dev.joordih.prozen.controllers;

import com.google.inject.Inject;
import dev.joordih.prozen.managers.models.impl.task.Task;
import dev.joordih.prozen.services.TaskService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import org.bson.types.ObjectId;

import java.util.List;

/*
 *
 *  * Copyright © 2025 Jordi Xavier
 *  *
 *  * Class: TaskController
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:34:22
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

@Controller("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Inject
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Post
    public HttpResponse<Task> create(@Body Task task) {
        return HttpResponse.created(taskService.create(task));
    }

    @Get
    public HttpResponse<List<Task>> findAll() {
        return HttpResponse.ok(taskService.findAll());
    }

    @Get("/assignee/{assigneeId}")
    public HttpResponse<List<Task>> findByAssignee(@PathVariable String assigneeId) {
        return HttpResponse.ok(taskService.findByAssignee(new ObjectId(assigneeId)));
    }

    @Get("/type/{type}")
    public HttpResponse<List<Task>> findByType(@PathVariable Task.TaskType type) {
        return HttpResponse.ok(taskService.findByType(type));
    }

    @Get("/status/{status}")
    public HttpResponse<List<Task>> findByStatus(@PathVariable Task.TaskStatus status) {
        return HttpResponse.ok(taskService.findByStatus(status));
    }

    @Put("/{id}")
    public HttpResponse<Task> update(@PathVariable String id, @Body Task task) {
        return HttpResponse.ok(taskService.update(id, task));
    }

    @Delete("/{id}")
    public HttpResponse<Void> delete(@PathVariable String id) {
        taskService.delete(id);
        return HttpResponse.noContent();
    }
}
