package com.ventogumi.recipe.model.scrap;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Scrap {
    @EmbeddedId
    private Scrap_pk scrap_pk;
}
