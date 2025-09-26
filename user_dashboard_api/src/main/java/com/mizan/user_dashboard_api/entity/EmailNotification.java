package com.mizan.user_dashboard_api.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailNotification {

    private boolean taskUpdates;
    private boolean comments;
    private boolean mentions;

}
