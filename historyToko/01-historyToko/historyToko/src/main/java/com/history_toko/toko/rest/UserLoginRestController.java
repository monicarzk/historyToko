package com.history_toko.toko.rest;

import com.history_toko.toko.entity.UserLogin;
import com.history_toko.toko.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.String;

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

    @GetMapping("/users/{userId}")
    public UserLogin getUserLogin(@PathVariable String userId) {

        UserLogin theUserLogin = userLoginService.findById(userId);

        if (theUserLogin == null) {
            throw new RuntimeException("UserLogin id not found - " + userId);
        }

        return theUserLogin;
    }

    @PostMapping("/users")
    public UserLogin addUserLogin(@RequestBody UserLogin theUserLogin) {

        String usernameFromRequest = theUserLogin.getUsername();

        theUserLogin.setUsername(usernameFromRequest);

        UserLogin dbUserLogin = userLoginService.save(theUserLogin);

        return dbUserLogin;

    }

}
