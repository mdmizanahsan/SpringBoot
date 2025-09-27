package com.mizan.user_dashboard_api.service.impl;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.mizan.user_dashboard_api.entity.Project;
import com.mizan.user_dashboard_api.entity.Task;
import com.mizan.user_dashboard_api.repository.ProjectRepository;
import com.mizan.user_dashboard_api.repository.TaskRepository;
import com.mizan.user_dashboard_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public Task create(String projectId, Task task) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        if (task.getDueDate() == null) {
            task.setDueDate(LocalDate.now().plusDays(7).atStartOfDay()); // default 7 din
        }

        task.setProject(project);
        return taskRepository.save(task);
    }


    public Task getById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }


    public Task update(String id, Task task) {
        Task existing = getById(id);

        if (task.getTitle() != null) existing.setTitle(task.getTitle());
        if (task.getStatus() != null) existing.setStatus(task.getStatus());
        if (task.getPriority() != null) existing.setPriority(task.getPriority());
        if (task.getDueDate() != null) existing.setDueDate(task.getDueDate());

        return taskRepository.save(existing);
    }

    public void deleteById(String id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getByProject(String projectId) {
        return taskRepository.findByProjectId(projectId);
    }
}
