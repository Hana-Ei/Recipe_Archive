package com.ventogumi.recipe.model.food;

import com.ventogumi.recipe.model.language.Language;
import com.ventogumi.recipe.model.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Data
public class Recipe_comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recipe_comment_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_comment_recipe", nullable = false)
    @ToString.Exclude
    private Recipe recipe_comment_recipe;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String recipe_comment_content;
    @Column(nullable = false)
    private LocalDateTime recipe_comment_createdate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_comment_user", nullable = false)
    private User recipe_comment_user;
    @Enumerated
    private Language recipe_comment_language;

}
