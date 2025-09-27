package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,String> {
    List<Project> findByTeamId(String teamId);
}
