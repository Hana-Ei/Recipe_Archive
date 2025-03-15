package com.ventogumi.recipe.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

// 스프링 시큐리티 설정
@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Cross-site request forgery(CSRF) 보안 비활성화
                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(request -> request
                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
                // 인증없이접근할 수 있는 URL을 설정
                .requestMatchers("/","users/login","/users/register", "/error").permitAll()
                // /admin/* URL은 ADMIN, MANAGER, USER 권한을 가진 사용자만 접근 가능
                .requestMatchers("/admin/*").hasAnyRole("ADMIN", "MANAGER")
                // 나머지 URL은 인증된 사용자만 접근 가능
                .anyRequest().authenticated())
                // 폼 로그인 방식을 활용
                .formLogin(formLogin -> formLogin
                        // 기본값으로 /login URL을 사용
                        // 사용자가 지정한 로그인 경로를 사용하겠다.
                        .loginPage("/users/login")
                        // 로그인 아이디의 파라미터 이름을 설정 기본값으로 username을 사용한다.
                        .loginProcessingUrl("/users/login") // 로그인 요청 URL
                        .usernameParameter("user_name")
//                        로그인 비밀번호의 파라미터 이름을 설정 기본값으로 password를 사용한다.
                        .passwordParameter("user_password")
                        // 로그인이 성공했을 때 이동할 경로
                        .defaultSuccessUrl("/users/login-success")
                        // 로그인이 실패했을 때 이동할 경로
//                        .failureUrl("/users/login-fail")
                        // 로그인 실패 처리 핸들러
                        .failureHandler(authenticationFailureHandler)
                        .permitAll())
        .logout(logout -> logout
                // 로그아웃 URL을 설정 (기본값은 /logout)
                .logoutUrl("/users/logout")
                // 로그아웃이 성공했을 때 이동할 경로
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                        .oauth2Login(oauth2 -> oauth2
                                .userInfoEndpoint(userInfo -> userInfo
                                        .userService(oAuth2UserService)
                                )
                        );


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 양방향 암호화 : 패스워드 <-> 암호화된 패스워드
        // 단방향 암호화 : 패스워드 -> 암호화된 패스워드 v
        return new BCryptPasswordEncoder();

    }
}
