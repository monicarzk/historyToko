package com.historyToko.caringin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginHistoriesController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "histories/login-histories";
    }

}
