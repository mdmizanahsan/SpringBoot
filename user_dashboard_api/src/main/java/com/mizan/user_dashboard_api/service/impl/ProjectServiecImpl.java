package com.mizan.user_dashboard_api.service.impl;

import com.mizan.user_dashboard_api.entity.Project;
import com.mizan.user_dashboard_api.entity.Team;
import com.mizan.user_dashboard_api.repository.ProjectRepository;
import com.mizan.user_dashboard_api.repository.TeamRepository;
import com.mizan.user_dashboard_api.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiecImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TeamRepository teamRepository;

    public Project create(String teamId , Project project) {
       Team team = teamRepository.findById(teamId)
               .orElseThrow( () -> new RuntimeException("Team Not Found"));
       project.setTeam(team);
       return projectRepository.save(project);
    }

    public Project getById(String id) {
        return projectRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Project Not Found"));
    }

    public List<Project> getByTeamId(String teamId) {
        return projectRepository.findByTeamId(teamId);
    }

    public Project update(String id, Project project) {
        Project existing = getById(id);
        if (project.getName() != null) existing.setName(project.getName());
        if (project.getStatus() != null) existing.setStatus(project.getStatus());
        if (project.getDueDate() != null) existing.setDueDate(project.getDueDate());
        return projectRepository.save(existing);
    }

    public void deleteById(String id) {
        projectRepository.deleteById(id);
    }
}
