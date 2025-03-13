package com.ventogumi.recipe.model.user;

import lombok.Data;

@Data
public class User_createDto {

    private String user_nickname;
    private String user_name;
    private String user_password;
    private String user_email;

    public User toEntity() {
        return User.builder()
                .user_nickname(user_nickname)
                .user_name(user_name)
                .user_password(user_password)
                .user_email(user_email)
                .build();
    }
}
