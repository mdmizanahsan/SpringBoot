package com.mizan.user_dashboard_api.entity;

import com.mizan.user_dashboard_api.domains.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Project {

    @Id
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
