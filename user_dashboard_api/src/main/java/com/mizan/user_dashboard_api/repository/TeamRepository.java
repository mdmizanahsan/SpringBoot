package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,String> {
}
