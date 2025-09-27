package com.mizan.user_dashboard_api.controller;

import com.mizan.user_dashboard_api.entity.Task;
import com.mizan.user_dashboard_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/tasks")
public class TaskController {

    private final TaskService taskService;


    @PostMapping
    public ResponseEntity<Task> create(@PathVariable String projectId, @RequestBody Task task) {
        try {
            Task created = taskService.create(projectId, task);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Get all tasks for project
    @GetMapping
    public ResponseEntity<List<Task>> getByProject(@PathVariable String projectId) {
        try {
            List<Task> tasks = taskService.getByProject(projectId);
            if (tasks.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok(tasks);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Get single task
    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable String id) {
        try {
            Task task = taskService.getById(id);
            return ResponseEntity.ok(task);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable String id, @RequestBody Task task) {
        try {
            Task updated = taskService.update(id, task);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            taskService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
