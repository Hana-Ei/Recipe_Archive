package com.ventogumi.recipe.model.alarm;

import com.ventogumi.recipe.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Alarm {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarm_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_user", nullable = false)
    private User alarm_user;
    @Column(nullable = false)
    private String alarm_content_kor;
    @Column(nullable = false)
    private String alarm_content_jap;
    @Column(nullable = false)
    private LocalDateTime alarm_created_time;
}
