package com.ventogumi.recipe.model.food;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Ingredient_code_pk implements Serializable {
    public Long ingredient_class_id;
    public Long ingredient_detail_id;
}
