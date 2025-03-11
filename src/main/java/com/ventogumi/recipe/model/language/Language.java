package com.ventogumi.recipe.model.language;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Language {
    KOREAN("한국어"),
    JAPANESE("일본어");

    private final String description;
}
