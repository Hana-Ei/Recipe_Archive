package com.ventogumi.recipe.controller;

import com.ventogumi.recipe.model.user.User;
import com.ventogumi.recipe.model.user.User_createDto;
import com.ventogumi.recipe.model.user.User_loginDto;
import com.ventogumi.recipe.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    public String loginFom(Model model) {
        model.addAttribute("user_loginDto", new User_loginDto());
        return "users/login";
    }

    // 로그인
    @PostMapping("users/login")
    public String login(
            @Validated  @ModelAttribute User_loginDto user_loginDto
            , BindingResult bindingResult
            , HttpServletRequest request,
            @RequestParam(name="redirectUrl", defaultValue = "/") String redirectUrl) {

        log.info("redirectURL:{}", redirectUrl);

        if(bindingResult.hasErrors()) {
            log.info("유효성 검증 실패");
            return "users/login";
        }
        log.info("user_loginDto: {}", user_loginDto);

        // user_name, user_password -> user
       User findUser = userService.getUserByUsername(user_loginDto.getUser_name());

        // 로그인 성공
        if(findUser == null || !findUser.getUser_password().equals(user_loginDto.getUser_password())) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "users/login";
        }
        // Request 객체에 저장돼 있는 Session 객체를 받아온다.
        HttpSession session = request.getSession();
        // session에 로그인한 사용자 정보를 저장한다.
        session.setAttribute("loginUser", findUser);

        return "redirect:" + redirectUrl;
    }



}
