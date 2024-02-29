package com.history_toko.toko.service;

import com.history_toko.toko.entity.UserLogin;
import java.lang.String;

import java.util.List;

public interface UserLoginService {

    List<UserLogin> findAll();

    UserLogin findById(String theId);

    UserLogin save(UserLogin theUserLogin);

    void deleteById(String theId);

}
