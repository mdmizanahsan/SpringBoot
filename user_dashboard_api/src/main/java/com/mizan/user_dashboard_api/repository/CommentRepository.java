package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String> {
    List<Comment> findByTaskId(String taskId);
}
