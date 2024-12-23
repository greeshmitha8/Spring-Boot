package com.example.taskmanagementapi.repository;

import com.example.taskmanagementapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
// Interacts with the database using Spring Data JPA and also Inherits methods like save(), findById(), findAll(), and deleteById() from JpaRepository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
