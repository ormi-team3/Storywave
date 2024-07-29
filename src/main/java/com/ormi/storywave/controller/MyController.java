package com.ormi.storywave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/my-page")
    public String showMyPage(Model model) {
        return "my-page";
    }
}
