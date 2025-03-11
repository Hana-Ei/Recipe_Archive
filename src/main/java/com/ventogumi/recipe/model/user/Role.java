package com.ventogumi.recipe.model.user;

import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    ROLE_ADMIN("최고 관리자"),
    ROLE_MANAGER("일반 관리자"),
    ROLE_USER("사용자");

    private final String description;
}
