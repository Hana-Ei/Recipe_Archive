package com.ventogumi.recipe.model.food;

import com.ventogumi.recipe.model.image.Image;
import com.ventogumi.recipe.model.language.Language;
import com.ventogumi.recipe.model.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Recipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_id;
    @Column(nullable = false, length = 255)
    private String recipe_title;
    @Column(nullable = false) @Lob
    private String recipe_content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_user", nullable = false)
    private User recipe_user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_image", nullable = true)
    private Image recipe_image; // 게시물 대표 사진입니다.
    @Column(nullable = false)
    private int recipe_view;
    @Column(nullable = false)
    private int recipe_like;
    @Column(nullable = false)
    private LocalDate recipe_write_time;
    @Enumerated
    private Language recipe_language; // 작성된 언어 판단은 밖에서

    // OneToMany
    @OneToMany(mappedBy = "recipe_comment_recipe")
    private List<Recipe_comment> recipe_comments;
    @OneToMany(mappedBy = "ingredient_recipe", cascade = CascadeType.ALL)
    private List<Ingredient> recipe_ingredients;
}
