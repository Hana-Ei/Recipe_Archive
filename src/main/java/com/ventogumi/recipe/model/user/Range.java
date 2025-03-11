package com.ventogumi.recipe.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Range {
    ALL("모두 공개"),
    FOLLOWED("팔로워에게만 공개"),
    CLOSED("비공개");

    private final String description;
}
