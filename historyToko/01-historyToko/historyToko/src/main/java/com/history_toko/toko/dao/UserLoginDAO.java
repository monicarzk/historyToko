package com.history_toko.toko.dao;

import com.history_toko.toko.entity.UserLogin;
import java.lang.String;

import java.util.List;

public interface UserLoginDAO {

    List<UserLogin> findAll();

    UserLogin findById(String theId);

    UserLogin save(UserLogin theUserLogin);

    void deleteById(String theId);
}
