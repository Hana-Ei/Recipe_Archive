package com.ventogumi.recipe.model.relish;

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
public class Relish_pk implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relish_user", nullable = false)
    private User relish_user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relish_recipe", nullable = true)
    private Recipe relish_recipe;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relish_community", nullable = true)
    private Community relish_community;


}
