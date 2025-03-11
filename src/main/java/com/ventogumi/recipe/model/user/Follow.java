package com.ventogumi.recipe.model.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Follow {
    @EmbeddedId
    private Follow_pk follow_pk;
}
