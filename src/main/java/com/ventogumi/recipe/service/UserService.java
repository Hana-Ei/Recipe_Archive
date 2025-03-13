package com.ventogumi.recipe.service;

import com.ventogumi.recipe.model.user.Range;
import com.ventogumi.recipe.model.user.Role;
import com.ventogumi.recipe.model.user.User;
import com.ventogumi.recipe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.ventogumi.recipe.model.user.Provider.LOCAL;
import static com.ventogumi.recipe.model.user.Range.ALL;
import static com.ventogumi.recipe.model.user.Rank.EGG;

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

        // provider가 없으면 local로 설정
        if(user.getUser_provider() == null) {
            user.setUser_provider(LOCAL);
        }

        // range가 없으면 all로 설정
        if(user.getUser_range() == null) {
            user.setUser_range(ALL);
        }

        //rank가 없으면 chick으로 설정
        if(user.getUser_rank() == null) {
            user.setUser_rank(EGG);
        }

        // register_date 설정
        user.setUser_register_date(LocalDate.now());

        // 유저 저장
        return userRepository.save(user);
    }
//
//
//    // id로 회원 정보를 조회하는 메서드
//    public User getUserById(Long id) {
//
//        Optional<User> result = userRepository.findById(id);
//
//        if(result.isPresent()) {
//            return result.get();
//        }
//
//        throw new RuntimeException("회원정보가 없습니다.");
//    }
//
//    // 전체 회원정보 조회
//    public List<User> getAll() {
//        List<User> result = userRepository.findAll();
//        return result;
//    }
//
//
//
//    public User getUserByUsername(String user_name) {
//        User user = userRepository.findByUser_name(user_name);
//        if(user == null) {
//            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
//        }
//        return user;
//    }

}
