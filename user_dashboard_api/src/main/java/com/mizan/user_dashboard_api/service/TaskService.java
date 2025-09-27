package com.mizan.user_dashboard_api.service;

import com.mizan.user_dashboard_api.entity.Task;

import java.util.List;

public interface TaskService {
    Task create(String projectId, Task task);
    Task getById(String id);
    Task update(String id, Task task);
    void deleteById(String id);
    List<Task> getByProject(String projectId);
}
