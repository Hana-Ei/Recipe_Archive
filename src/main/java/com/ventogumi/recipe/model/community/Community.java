package com.ventogumi.recipe.model.community;

import com.ventogumi.recipe.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Community {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long community_id;
    @Column(nullable = false, length = 255)
    private String community_title;
    @Column(nullable = false) @Lob
    private String community_content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_user", nullable = false)
    private User community_user;
    @Column(nullable = false)
    private int community_view;
    @Column(nullable = false)
    private LocalDateTime community_write_time;

//    @OneToMany() // 좋아요 수 계산용
//    private List<>
    @OneToMany(mappedBy = "community_comment_community")
    private List<Community_comment> community_comments;
}
