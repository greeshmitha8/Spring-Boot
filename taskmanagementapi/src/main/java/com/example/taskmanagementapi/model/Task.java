package com.example.taskmanagementapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity//it makes the class as JPA entity that maps to a database table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//automatically generates the primary key
    private Long id;

    @NotNull
    @Size(min = 0, max = 100)
    private String title;

    private String description;

    private LocalDateTime dueDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.PENDING;//TaskStatus enum to a database

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Automatically set the createdAt timestamp before saving the task for the first time
    @PrePersist
    public void onPrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Automatically set the updatedAt timestamp whenever the task is updated
    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum TaskStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
}



