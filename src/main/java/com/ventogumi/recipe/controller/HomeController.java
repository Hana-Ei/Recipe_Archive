package com.ventogumi.recipe.controller;

import com.ventogumi.recipe.config.AuthenticatedUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
    public String home(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
//        log.info("authenticatedUser: {}", authenticatedUser.getUsername());
        return "index";
    }
}
