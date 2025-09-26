package com.mizan.user_dashboard_api.repository;

import com.mizan.user_dashboard_api.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Settings,Long> {
}
