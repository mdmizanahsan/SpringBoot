package com.mizan.user_dashboard_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Builder
public class Team {

    @Id
    private String id;

    private String name;
    @ManyToMany
    @JoinTable(
            name = "team_members",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members;


    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Project> projects;
}
