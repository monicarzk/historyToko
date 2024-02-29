package com.history_toko.toko.service;

import com.history_toko.toko.dao.UserLoginDAO;
import com.history_toko.toko.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private UserLoginDAO userLoginDAO;

    @Autowired
    public UserLoginServiceImpl(UserLoginDAO theUserLoginDAO) {
        userLoginDAO = theUserLoginDAO;
    }

    @Override
    public List<UserLogin> findAll() {
        return userLoginDAO.findAll();
    }
}
