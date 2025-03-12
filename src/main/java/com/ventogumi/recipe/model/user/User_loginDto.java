package com.ventogumi.recipe.model.user;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class User_loginDto {

    @NotNull
    private String user_name;
    private String user_password;
}
