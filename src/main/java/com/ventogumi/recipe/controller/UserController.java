package com.ventogumi.recipe.controller;

import com.ventogumi.recipe.model.user.User;
import com.ventogumi.recipe.model.user.User_createDto;
import com.ventogumi.recipe.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    //회원가입 페이지 이동
    @GetMapping(path = "users/register")
    public String register(Model model) {
        User_createDto user_createDto = new User_createDto();
        model.addAttribute("user_createDto", new User_createDto());
        return "users/register";

    }

    // 회원가입
    @PostMapping("users/register")
    public String registerUser(
            @Validated @ModelAttribute User_createDto user_createDto
            , BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.info("유효성 검증 실패");
            return "users/register";
        }


        log.info("user_createDto: {}", user_createDto);
        // usercreateDto -> user
        User registeredUser = userService.saveUser(user_createDto.toEntity());
        return "redirect:/";
    }

    // 로그인 페이지 이동
    @GetMapping("users/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }

    // 로그인 성공 시 이동 URL
    @GetMapping("users/login-success")
    public String loginSuccess() {
        log.info("로그인 성공!");
        return "redirect:/";
    }

    // 로그인 실패 시 이동 URL
    @GetMapping("users/login-fail")
    public String loginFail() {
        log.info("로그인 실패!");
        return "redirect:/users/login";
    }
//     // 마이페이지 정보 조회 API
//     @GetMapping("/mypage")
//     public ResponseEntity<User> getUserProfile(@AuthenticationPrincipal UserDetails userDetails) {
//         if (userDetails == null) {
//             return ResponseEntity.status(401).build(); // 로그인 안 했으면 401 Unauthorized
//         }
//         User user = userService.getUserByUsername(userDetails.getUsername());
//         return ResponseEntity.ok(user);
//     }


}
