package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,String> {
    List<Task> findByProjectId(String projectId);
}
