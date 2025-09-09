package com.mizan.financeapp.Repository;

import com.mizan.financeapp.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
