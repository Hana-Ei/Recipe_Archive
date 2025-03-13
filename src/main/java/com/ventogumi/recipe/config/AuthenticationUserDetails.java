package com.ventogumi.recipe.config;

import com.ventogumi.recipe.model.user.User;
import com.ventogumi.recipe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 1. 로그인 페이지에서 로그인 시도를 하면
// 2. UserDetailsService 에서 로그인을 시도를 가로챈다.
// 3. LoadUserByUsername 메소드를 실행한다.
// 4. 파라밈터로 받은 username에 해당하는 유저를 찾아서 UserDetail 타입의 객체를 리턴한다.

@RequiredArgsConstructor
@Service
public class AuthenticationUserDetails implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
       User user = userRepository.findByUser_name(user_name).orElseThrow(() ->
                new UsernameNotFoundException("사용자를 찾을 수 없습니다."));


        return new AuthenticatedUser(user);
    }

}
