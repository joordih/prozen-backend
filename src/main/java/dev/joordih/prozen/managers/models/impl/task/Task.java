package dev.joordih.prozen.managers.models.impl.task;

import dev.joordih.prozen.managers.models.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

/*
 *
 *  * Copyright 2025 Jordi Xavier
 *  *
 *  * Class: Task
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:40:40
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Model {
    private String id;
    private String title;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;
    private TaskType type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime dueDate;
    private ObjectId assigneeId;
    private boolean isOverdue;

    public enum TaskType {
        TODO("TO-DO"),
        IN_PROGRESS("In Progress"),
        FINISHED("Finished"),
        BUG("Bug"),
        BLOCKED("Blocked");

        private final String displayName;

        TaskType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum TaskStatus {
        OPEN("Open"),
        IN_PROGRESS("In Progress"),
        COMPLETED("Completed"),
        CANCELLED("Cancelled");

        private final String displayName;

        TaskStatus(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum TaskPriority {
        LOW("Low"),
        MEDIUM("Medium"),
        HIGH("High"),
        URGENT("Urgent");

        private final String displayName;

        TaskPriority(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
