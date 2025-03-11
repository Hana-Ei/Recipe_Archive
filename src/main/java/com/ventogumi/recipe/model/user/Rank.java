package com.ventogumi.recipe.model.user;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Rank {
    EGG("계란"),
    CHICK("병아리"),
    CHICKEN("닭");

    private final String description;
}
