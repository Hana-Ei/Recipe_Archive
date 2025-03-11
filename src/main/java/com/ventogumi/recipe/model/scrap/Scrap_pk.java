package com.ventogumi.recipe.model.scrap;

import com.ventogumi.recipe.model.community.Community;
import com.ventogumi.recipe.model.food.Recipe;
import com.ventogumi.recipe.model.user.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Scrap_pk implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scrap_user", nullable = false)
    private User scrap_user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scrap_recipe", nullable = true)
    private Recipe scrap_recipe;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scrap_community", nullable = true)
    private Community scrap_community;
}
