package com.shahab.university_api.service.impl;

import com.shahab.university_api.entity.AuditLog;
import com.shahab.university_api.repository.AuditLogRepository;
import com.shahab.university_api.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public List<AuditLog> findAll() {
        return auditLogRepository.findAll();
    }

    @Override
    public AuditLog findById(String id) {
        return auditLogRepository.findById(id).orElse(null);
    }

    @Override
    public AuditLog saveAuditLog(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }
}