package com.shahab.university_api.service;

import com.shahab.university_api.entity.AuditLog;

import java.util.List;

public interface AuditLogService {
    List<AuditLog> findAll();
    AuditLog findById(String id);
    AuditLog saveAuditLog(AuditLog auditLog);
}
