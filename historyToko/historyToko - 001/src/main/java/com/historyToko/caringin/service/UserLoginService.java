package com.historyToko.caringin.service;

import com.historyToko.caringin.entity.UserLogin;

import java.util.List;

public interface UserLoginService {

    List<UserLogin> findAll();

    UserLogin findByUsername(String theUsername);

    UserLogin save(UserLogin theUserLogin);

    void deleteByUsername(String theUsername);
}
