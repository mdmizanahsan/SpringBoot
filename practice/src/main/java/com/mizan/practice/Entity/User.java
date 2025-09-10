package com.mizan.practice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;

    @Column(name = "user_name")
    @NotBlank(message = "User Name is required")
    private String userName;

    @Column(name = "college_id")
    private String collegeId;

    @Column(name = "campus_id")
    private String campusId;

    @Column(name = "university_id")
    private String universityId;

    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "first_name" , length = 100)
    private String firstName;

    @Column(name = "last_name" , length = 100)
    private String lastName;

    @Column(name = "email_id", unique = true, nullable = false)
    @NotBlank(message = "Email is required")
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" , message = "Invalid Email!!")
    private String emailId;

    @Column(name = "contact_no")
    @Size(min = 10, max = 15, message = "Contact number must be between 10 and 15 digits")
    private String contactNo;

    @Column(name = "preferred_language")
    private String preferredLanguage;

    @Column(name = "is_staff")
    private boolean isStaff;

    @Column(name = "is_super_user")
    private boolean isSuperUser;

    @Column(name = "is_college_admin")
    private boolean isCollegeAdmin;

    @Column(name = "is_campus_admin")
    private boolean isCampusAdmin;

    @Column(name = "is_department_admin")
    private boolean isDepartmentAdmin;

    @Column(name = "is_course_coordinator")
    private boolean isCourseCoordinator;

    @Column(name = "is_active")
    private boolean isActive;
}
