package com.ventogumi.recipe.config;

import com.ventogumi.recipe.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthenticatedUser implements UserDetails {

    private User user;

    public AuthenticatedUser(User user) {
        this.user = user;
    }

    // 사용자의 권한 정보를 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new SimpleGrantedAuthority(user.getUser_role().name()));
        return collect;
    }

    // 사용자의 패스워드 리턴
    @Override
    public String getPassword() {

        return user.getUser_password();
    }

    // 사용자의 아이디를 리턴
    @Override
    public String getUsername() {
        return user.getUser_name();
    }

}
