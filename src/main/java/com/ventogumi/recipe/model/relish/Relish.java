package com.ventogumi.recipe.model.relish;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Relish {
    @EmbeddedId
    private Relish_pk relish_pk;
}
