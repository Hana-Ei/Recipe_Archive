package com.ventogumi.recipe.service;

import com.ventogumi.recipe.model.user.Role;
import com.ventogumi.recipe.model.user.User;
import com.ventogumi.recipe.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    // 회원가입
    @Transactional
    public User saveUser(User user){
        // 패스워드 암호화
        user.setUser_password(passwordEncoder.encode(user.getUser_password()));
        // 권한부여
        user.setUser_role(Role.ROLE_USER);
        return userRepository.save(user);
    }
}
