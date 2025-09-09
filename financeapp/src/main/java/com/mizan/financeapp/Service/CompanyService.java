package com.mizan.financeapp.Service;

import com.mizan.financeapp.Entity.Company;
import com.mizan.financeapp.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // GET all companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // GET company by ID
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id " + id));
    }

    // POST create new company
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    // DELETE company by ID
    public void deleteCompany(Long id) {
        Company company = getCompanyById(id);
        companyRepository.delete(company);
    }
}
