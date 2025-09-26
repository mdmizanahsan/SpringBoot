package com.mizan.user_dashboard_api.entity;

import com.mizan.user_dashboard_api.entity.enums.TaskPriority;
import com.mizan.user_dashboard_api.entity.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table
@Builder
public class Task {

    @Id
    private String id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<SubTask> subTasks;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comment> comments;

}
