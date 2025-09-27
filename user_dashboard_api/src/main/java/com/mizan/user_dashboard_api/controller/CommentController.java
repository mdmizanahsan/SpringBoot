package com.mizan.user_dashboard_api.controller;

import com.mizan.user_dashboard_api.entity.Comment;
import com.mizan.user_dashboard_api.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping("/api/tasks/{taskId}/comments")
public class CommentController {


    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> create(@PathVariable String taskId, @RequestBody Comment comment) {
        try {
            return new ResponseEntity<>(commentService.create(taskId, comment), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getByTask(@PathVariable String taskId) {
        try {
            List<Comment> comments = commentService.getByTask(taskId);
            if (comments.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok(comments);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(commentService.getById(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(@PathVariable String id, @RequestBody Comment comment) {
        try {
            return ResponseEntity.ok(commentService.update(id, comment));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            commentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
