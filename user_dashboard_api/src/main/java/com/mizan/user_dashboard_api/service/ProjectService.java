package com.mizan.user_dashboard_api.service;

import com.mizan.user_dashboard_api.entity.Project;

import java.util.List;

public interface ProjectService {

    Project create(String teamId, Project project);
    Project getById(String id);
    List<Project> getByTeamId(String teamId);
    Project update(String id, Project project);
    void deleteById(String id);
}
