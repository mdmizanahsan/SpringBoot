package com.mizan.user_dashboard_api.service;

import com.mizan.user_dashboard_api.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment create(String taskId, Comment comment);

    Comment getById(String id);

    Comment update(String id, Comment comment);

    void deleteById(String id);

    List<Comment> getByTask(String taskId);
}
