package com.mizan.user_dashboard_api.controller;

import com.mizan.user_dashboard_api.entity.Settings;
import com.mizan.user_dashboard_api.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/settings")
public class SettingController {

    private final SettingService settingService;


    @GetMapping("/{id}")
    public ResponseEntity<Settings> getById(@PathVariable Long id) {
        try {
            Settings settings = settingService.getById(id);
            return new ResponseEntity<>(settings, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Settings> update(@PathVariable Long id, @RequestBody Settings settings) {
        try {
            Settings updated = settingService.update(id, settings);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
