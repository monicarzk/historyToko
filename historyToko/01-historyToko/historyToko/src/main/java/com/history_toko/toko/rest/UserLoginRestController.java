package com.history_toko.toko.rest;

import com.history_toko.toko.entity.UserLogin;
import com.history_toko.toko.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserLoginRestController {

    private UserLoginService userLoginService;

    @Autowired
    public UserLoginRestController(UserLoginService theUserLoginService) {
        userLoginService = theUserLoginService;
    }

    @GetMapping("/users")
    public List<UserLogin> findAll() {
        return userLoginService.findAll();
    }

}
