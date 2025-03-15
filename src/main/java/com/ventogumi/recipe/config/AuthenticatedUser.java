package com.ventogumi.recipe.config;

import com.ventogumi.recipe.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AuthenticatedUser implements UserDetails, OAuth2User {

    private User user;
    private Map<String, Object> attributes;

    // UserDetailsService 에서 리턴한 AuthenticatedUser 객체를 생성할 때 사용
    public AuthenticatedUser(User user) {
        this.user = user;
    }
    // OAuth2UserDetailsService 에서 리턴한 AuthenticatedUser 객체를 생성할 때 사용
    public AuthenticatedUser(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
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

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return user.getUser_name();
    }
}
