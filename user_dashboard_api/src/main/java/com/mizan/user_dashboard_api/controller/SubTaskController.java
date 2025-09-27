package com.mizan.user_dashboard_api.controller;

import com.mizan.user_dashboard_api.entity.SubTask;
import com.mizan.user_dashboard_api.service.SubTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tasks/{taskId}/subtasks")
public class SubTaskController {

    private final SubTaskService subTaskService;

    @PostMapping
    public ResponseEntity<SubTask> create(@PathVariable String taskId, @RequestBody SubTask subTask) {
        try {
            SubTask created = subTaskService.create(taskId, subTask);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<SubTask>> getByTask(@PathVariable String taskId) {
        try {
            List<SubTask> subtasks = subTaskService.getByTask(taskId);
            if (subtasks.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok(subtasks);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubTask> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(subTaskService.getById(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubTask> update(@PathVariable String id, @RequestBody SubTask subTask) {
        try {
            return ResponseEntity.ok(subTaskService.update(id, subTask));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            subTaskService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
