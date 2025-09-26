package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask,String> {
}
