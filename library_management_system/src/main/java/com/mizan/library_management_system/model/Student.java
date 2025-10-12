package com.mizan.library_management_system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @Column(unique = true,nullable = false)

    private String email;

    @Column(unique = true,nullable = false)
    private String phone;


}
