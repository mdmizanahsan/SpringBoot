package com.mizan.library_management_system.repository;

import com.mizan.library_management_system.model.IssueRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRecordRepository extends JpaRepository<IssueRecord,Long> {
}
