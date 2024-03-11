package com.historyToko.caringin.controller;

import com.historyToko.caringin.entity.UserLogin;
import com.historyToko.caringin.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private UserLoginService userLoginService;

    public UserLoginController(UserLoginService theUserLoginService) {
        userLoginService = theUserLoginService;
    }

    @GetMapping("/list")
    public String listUserLogins(Model theModel) {

        List<UserLogin> theUserLogins = userLoginService.findAll();

        theModel.addAttribute("userLogins", theUserLogins);

        return "list-userLogins";
    }
}
