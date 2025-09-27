package com.mizan.user_dashboard_api.service;

import com.mizan.user_dashboard_api.entity.Settings;

public interface SettingService {
    Settings getById(Long id);

    Settings update(Long id, Settings settings);
}
