package com.historyToko.caringin.dao;

import com.historyToko.caringin.entity.UserLogin;

import java.util.List;

public interface UserLoginDAO {

    List<UserLogin> findAll();

    UserLogin findByUsername(String theUsername);

    UserLogin save(UserLogin theUserLogin);

    void deleteByUsername(String theUsername);
}
