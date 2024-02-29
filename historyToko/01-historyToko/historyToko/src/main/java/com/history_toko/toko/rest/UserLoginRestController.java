package com.history_toko.toko.rest;

import com.history_toko.toko.dao.UserLoginDAO;
import com.history_toko.toko.entity.UserLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserLoginRestController {

    private UserLoginDAO userLoginDAO;

    public UserLoginRestController(UserLoginDAO theUserLoginDAO) {
        userLoginDAO = theUserLoginDAO;
    }

    @GetMapping("/users")
    public List<UserLogin> findAll() {
        return userLoginDAO.findAll();
    }

}
