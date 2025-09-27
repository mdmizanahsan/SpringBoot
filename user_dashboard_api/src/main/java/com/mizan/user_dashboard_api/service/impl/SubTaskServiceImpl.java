package com.mizan.user_dashboard_api.service.impl;

import com.mizan.user_dashboard_api.entity.SubTask;
import com.mizan.user_dashboard_api.entity.Task;
import com.mizan.user_dashboard_api.repository.SubTaskRepository;
import com.mizan.user_dashboard_api.repository.TaskRepository;
import com.mizan.user_dashboard_api.service.SubTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubTaskServiceImpl implements SubTaskService {

    private final SubTaskRepository subTaskRepository;
    private final TaskRepository taskRepository;


    @Override
    public SubTask create(String taskId, SubTask subTask) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        subTask.setTask(task);
        return subTaskRepository.save(subTask);
    }

    @Override
    public SubTask getById(String id) {
        return subTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubTask not found"));
    }

    @Override
    public SubTask update(String id, SubTask subTask) {
        SubTask existing = getById(id);
        if (subTask.getTitle() != null) existing.setTitle(subTask.getTitle());
        existing.setCompleted(subTask.getCompleted());
        return subTaskRepository.save(existing);
    }

    @Override
    public void deleteById(String id) {
        subTaskRepository.deleteById(id);
    }

    @Override
    public List<SubTask> getByTask(String taskId) {
        return subTaskRepository.findByTaskId(taskId);
    }

}
