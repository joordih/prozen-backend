package dev.joordih.prozen.managers.models.impl.task;

import dev.joordih.prozen.managers.database.MongoConnector;
import dev.joordih.prozen.managers.repository.MongoObjectRepository;
import jakarta.inject.Singleton;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class TaskRepository extends MongoObjectRepository<Task> {

    public TaskRepository(MongoConnector mongoConnector) {
        super(mongoConnector.getCollection("tasks", Task.class));
    }

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        getCollection().find().forEach(tasks::add);
        return tasks;
    }

    public List<Task> findByAssignee(ObjectId assigneeId) {
        List<Task> tasks = new ArrayList<>();
        getCollection().find(Filters.eq("assigneeId", assigneeId)).forEach(tasks::add);
        return tasks;
    }

    public List<Task> findByType(Task.TaskType type) {
        List<Task> tasks = new ArrayList<>();
        getCollection().find(Filters.eq("type", type.name())).forEach(tasks::add);
        return tasks;
    }

    public List<Task> findByStatus(Task.TaskStatus status) {
        List<Task> tasks = new ArrayList<>();
        getCollection().find(Filters.eq("status", status.name())).forEach(tasks::add);
        return tasks;
    }

    public Task create(Task task) {
        save(task);
        return task;
    }

    public Task update(String id, Task task) {
        save(task);
        return task;
    }

    public void delete(String id) {
        remove(id);
    }
}
