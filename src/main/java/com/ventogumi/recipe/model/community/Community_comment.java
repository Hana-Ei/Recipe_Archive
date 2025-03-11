package com.ventogumi.recipe.model.community;

import com.ventogumi.recipe.model.language.Language;
import com.ventogumi.recipe.model.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Data
public class Community_comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long community_comment_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_comment_community", nullable = false)
    @ToString.Exclude
    private Community community_comment_community;
    @Column(nullable = false) @Lob
    private String community_comment_content;
    @Column(nullable = false)
    private LocalDateTime community_comment_write_time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_comment_user", nullable = false)
    private User community_comment_user;
    @Enumerated
    private Language community_comment_language;
}
