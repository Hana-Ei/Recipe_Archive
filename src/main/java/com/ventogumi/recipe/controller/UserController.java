package com.ventogumi.recipe.controller;

import com.ventogumi.recipe.model.user.User;
import com.ventogumi.recipe.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    //회원가입 페이지 이동
    @GetMapping(path = "users/register")
    public String register(Model model) {

        model.addAttribute("user", new User());
        return "users/register";

    }

    // 회원가입
    @PostMapping("users/register")
    public String registerUser(@ModelAttribute User user) {
        log.info("user: {}", user);
        userService.saveUser(user);
        return "redirect:/";
    }

    // 로그인 페이지 이동
    @GetMapping("users/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }
}
