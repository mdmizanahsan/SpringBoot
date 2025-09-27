package com.mizan.user_dashboard_api.service.impl;

import com.mizan.user_dashboard_api.entity.Comment;
import com.mizan.user_dashboard_api.entity.Task;
import com.mizan.user_dashboard_api.repository.CommentRepository;
import com.mizan.user_dashboard_api.repository.TaskRepository;
import com.mizan.user_dashboard_api.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Override
    public Comment create(String taskId, Comment comment) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        comment.setTask(task);
        comment.setTimestamp(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    public Comment getById(String id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @Override
    public Comment update(String id, Comment comment) {
        Comment existing = getById(id);
        if (comment.getMessage() != null) existing.setMessage(comment.getMessage());
        return commentRepository.save(existing);
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getByTask(String taskId) {
        return commentRepository.findByTaskId(taskId);
    }
}
