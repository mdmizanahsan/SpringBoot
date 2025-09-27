package com.mizan.user_dashboard_api.service;

import com.mizan.user_dashboard_api.entity.SubTask;

import java.util.List;

public interface SubTaskService {
    SubTask create(String taskId, SubTask subTask);

    SubTask getById(String id);

    SubTask update(String id, SubTask subTask);

    void deleteById(String id);

    List<SubTask> getByTask(String taskId);
}
