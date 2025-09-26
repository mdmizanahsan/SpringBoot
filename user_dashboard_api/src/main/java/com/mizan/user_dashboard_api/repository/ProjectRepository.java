package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,String> {
}
