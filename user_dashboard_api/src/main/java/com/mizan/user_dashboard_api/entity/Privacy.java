package com.mizan.user_dashboard_api.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Privacy {
    private boolean profileVisible;
    private boolean showOnlineStatus;
}
