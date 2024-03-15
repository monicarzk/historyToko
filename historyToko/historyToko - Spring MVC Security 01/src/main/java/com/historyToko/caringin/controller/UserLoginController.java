package com.historyToko.caringin.controller;

import com.historyToko.caringin.entity.History;
import com.historyToko.caringin.entity.UserLogin;
import com.historyToko.caringin.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private UserLoginService userLoginService;

    public UserLoginController(UserLoginService theUserLoginService) {
        userLoginService = theUserLoginService;
    }

    @GetMapping("/showLoginPageUsers")
    public String showLoginPageUsers() {

        return "userLogins/login-users";
    }

    @GetMapping("/list")
    public String listUserLogins(Model theModel) {

        List<UserLogin> theUserLogins = userLoginService.findAll();

        theModel.addAttribute("userLogins", theUserLogins);

        return "userLogins/list-userLogins";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        UserLogin theUserLogin = new UserLogin();

        theModel.addAttribute("userLogin", theUserLogin);

        return "userLogins/userLogin-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userLoginId") int theId, Model theModel) {

        UserLogin theUserLogin = userLoginService.findById(theId);

        theModel.addAttribute("userLogin", theUserLogin);

        return "userLogins/userLogin-form";
    }

    @PostMapping("/save")
    public String saveUserLogin(@ModelAttribute("userLogin") UserLogin theUserLogin) {

        userLoginService.save(theUserLogin);

        return "redirect:/users/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userLoginId") int theId){

        userLoginService.deleteById(theId);

        return "redirect:/users/list";
    }
}
