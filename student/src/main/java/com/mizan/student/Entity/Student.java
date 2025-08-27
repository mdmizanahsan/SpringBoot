package com.mizan.student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Long age;
    private String gender;
    private String discreption;
    private Long contact;

    public Student() {
    }
    public Student(Long id, String name, String email, Long age, String gender, String discreption, Long contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.discreption = discreption;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAge() { return age; }

    public void setAge(Long age) { this.age = age; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getDiscreption() { return discreption; }

    public void setDiscreption(String discreption) { this.discreption = discreption; }

    public Long getContact() { return contact; }

    public void setContact(Long contact) { this.contact = contact; }
}
