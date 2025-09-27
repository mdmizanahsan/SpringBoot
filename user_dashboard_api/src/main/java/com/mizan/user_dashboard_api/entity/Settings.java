package com.mizan.user_dashboard_api.entity;

import com.mizan.user_dashboard_api.domains.Language;
import com.mizan.user_dashboard_api.domains.Theme;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Theme theme;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Embedded
    private EmailNotification emailNotifications;

    @Embedded
    private Privacy privacy;


}
