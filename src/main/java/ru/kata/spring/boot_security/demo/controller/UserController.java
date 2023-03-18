package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class UserController {

    @GetMapping("admin")
    public String admin() {
        return "adminpage";
    }

    @GetMapping("user")
    public String user() {
        return "userpage";
    }

}
