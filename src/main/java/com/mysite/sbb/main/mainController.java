package com.mysite.sbb.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

    @GetMapping("/")
    public String root() {
        return "redirect:/article/list";
    }
}
