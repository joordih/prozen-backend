package dev.joordih.prozen.services;

import dev.joordih.prozen.managers.models.impl.Task;
import org.bson.types.ObjectId;
import java.util.List;

public interface TaskService {
    List<Task> findAll();
    List<Task> findByAssignee(ObjectId assigneeId);
    List<Task> findByType(Task.TaskType type);
    List<Task> findByStatus(Task.TaskStatus status);
    Task create(Task task);
    Task update(String id, Task task);
    void delete(String id);
}
