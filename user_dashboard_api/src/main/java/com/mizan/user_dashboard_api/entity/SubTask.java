package com.mizan.user_dashboard_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Builder
public class SubTask {

    @Id
    private String id;

    private String title;

    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
