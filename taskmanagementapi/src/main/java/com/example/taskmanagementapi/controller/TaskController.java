package com.example.taskmanagementapi.controller;

import com.example.taskmanagementapi.model.Task;
import com.example.taskmanagementapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
//This controller exposes RESTful endpoints for performing CRUD operations on tasks.
@RestController // HTTP requests and returns to JSON
@RequestMapping("/api/tasks")//URL for all endpoints is set to the /api/tasks.
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping // used to get all the list of task 
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();// fetch all tasks-> JASON(list)
    }

    @GetMapping("/{id}")//by ID
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) { //@Valid to validate the input based on constraints in the Task model.
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);  // Delete task
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

