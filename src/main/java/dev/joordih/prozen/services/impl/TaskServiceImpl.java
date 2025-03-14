package dev.joordih.prozen.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dev.joordih.prozen.managers.models.impl.Task;
import dev.joordih.prozen.managers.repository.TaskRepository;
import dev.joordih.prozen.services.TaskService;
import org.bson.types.ObjectId;
import java.time.LocalDateTime;
import java.util.List;

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
