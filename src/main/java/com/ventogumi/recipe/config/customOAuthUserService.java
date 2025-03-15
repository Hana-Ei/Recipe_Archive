package com.ventogumi.recipe.config;

import com.ventogumi.recipe.model.user.Provider;
import com.ventogumi.recipe.model.user.Role;
import com.ventogumi.recipe.model.user.User;
import com.ventogumi.recipe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static com.ventogumi.recipe.model.user.Range.ALL;
import static com.ventogumi.recipe.model.user.Rank.EGG;

// 소셜로그인을 성공했을 때 로그인 정보에 대한 값을 loadUser 메소드를 통해 가져온다.
@Slf4j
@RequiredArgsConstructor
@Service
public class customOAuthUserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("loadUser 메소드 실행");
        log.info("userRequest: {}", userRequest);
        log.info("userRequestget.ClientRegistration(): {}", userRequest.getClientRegistration());
        log.info("userRequestget.getAccessToken : {}", userRequest.getAccessToken());

        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("oAuth2User: {}", oAuth2User);
        log.info("oAuth2User.getAttributes: {}", oAuth2User.getAttributes());

        // 소셜로그인을 통해 가져온 정보를 User 객체에 담아서 AuthenticatedUser 객체를 생성한다.
        // 1. 서비스에 처음 로그인을 하는 사용자
        // -> 자동으로 회원가입을 시킨다.
        // username은 이메일을 사용, 패스워드는 임이의 값 1234로 넣는다.

        // 2. 기존에 서비스에 가입한 사용자
        // -> 이미 회우너가입이 되어 있기 때문에 회원 DB에서 정보를 가져온다.

        String user_email = "";
        String user_name = "";

        User user = null;
        Optional<User> findUser = userRepository.findByUser_name(user_name);
        if (findUser.isPresent()){
            //이미 존재하는 회원
            user = findUser.get();
        }else{
            // 회원가입을 진행
            // ** 나중에 구글에서 프로필 사진 받아와서 설정해주세요
            user_email = oAuth2User.getAttribute("email");
            user_name = oAuth2User.getAttribute("name");
            user = new User();
            user.setUser_name(user_email);
            user.setUser_password("1234");
            user.setUser_email(user_email);
            user.setUser_role(Role.ROLE_USER);
            user.setUser_provider(Provider.GOOGLE);
            user.setUser_nickname(user_name); // 구글에서 설정한 이름
            user.setUser_register_date(LocalDate.now());
            user.setUser_range(ALL);
            user.setUser_rank(EGG);
            userRepository.save(user);

        }

        return new AuthenticatedUser(user, oAuth2User.getAttributes());
    }
}
