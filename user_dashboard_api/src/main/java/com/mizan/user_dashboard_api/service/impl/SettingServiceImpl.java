package com.mizan.user_dashboard_api.service.impl;

import com.mizan.user_dashboard_api.entity.Settings;
import com.mizan.user_dashboard_api.repository.SettingRepository;
import com.mizan.user_dashboard_api.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {

    private final SettingRepository settingRepository;

    @Override
    public Settings getById(Long id) {
        return settingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Settings not found"));
    }

    @Override
    public Settings update(Long id, Settings settings) {
        Settings existing = getById(id);
        if (settings.getTheme() != null) existing.setTheme(settings.getTheme());
        if (settings.getLanguage() != null) existing.setLanguage(settings.getLanguage());
        if (settings.getEmailNotifications() != null) existing.setEmailNotifications(settings.getEmailNotifications());
        if (settings.getPrivacy() != null) existing.setPrivacy(settings.getPrivacy());
        return settingRepository.save(existing);
    }
}
