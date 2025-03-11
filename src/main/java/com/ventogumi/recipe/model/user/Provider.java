package com.ventogumi.recipe.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Provider {
    LOCAL("아카이브"),
    GOOGLE("구글"),
    KAKAO("카카오");
    private final String description;
}
