package com.historyToko.caringin.rest;

import com.historyToko.caringin.entity.UserLogin;
import com.historyToko.caringin.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{userUsername}")
    public UserLogin getUserLogin(@PathVariable String userUsername) {

        UserLogin theUserLogin = userLoginService.findByUsername(userUsername);

        if (theUserLogin == null) {
            throw new RuntimeException("UserLogin username not found - " + userUsername);

        }

        return theUserLogin;
    }

    @PostMapping("/users")
    public UserLogin addUserLogin(@RequestBody UserLogin theUserLogin) {

        UserLogin dbUserLogin = userLoginService.save(theUserLogin);

        return dbUserLogin;

    }

    @PutMapping("/users")
    public UserLogin updateUserLogin(@RequestBody UserLogin theUserLogin) {

        UserLogin dbUserLogin = userLoginService.save(theUserLogin);

        return dbUserLogin;
    }

    @DeleteMapping("/users/{userUser}")
    public String deleteUserLogin(@PathVariable String userUser) {

        UserLogin tempUserLogin = userLoginService.findByUsername(userUser);

        if (tempUserLogin == null) {
            throw new RuntimeException("UserLogin username not found - " + userUser);
        }

        userLoginService.deleteByUsername(userUser);

        return "Deleted user_login id - " + userUser;
    }
}
