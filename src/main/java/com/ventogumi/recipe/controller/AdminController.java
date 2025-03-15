package com.ventogumi.recipe.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {

    @GetMapping("/admin/main")
    public String main() {
        return "redirect:/";
    }
}
