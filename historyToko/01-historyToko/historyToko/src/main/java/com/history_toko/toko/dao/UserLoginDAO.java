package com.history_toko.toko.dao;

import com.history_toko.toko.entity.UserLogin;

import java.util.List;

public interface UserLoginDAO {

    List<UserLogin> findAll();

}
