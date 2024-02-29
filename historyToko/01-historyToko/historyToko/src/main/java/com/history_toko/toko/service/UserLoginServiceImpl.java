package com.history_toko.toko.service;

import com.history_toko.toko.dao.UserLoginDAO;
import com.history_toko.toko.entity.UserLogin;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.String;

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

    @Override
    public UserLogin findById(String theId) {
        return userLoginDAO.findById(theId);
    }

    @Transactional
    @Override
    public UserLogin save(UserLogin theUserLogin) {
        return userLoginDAO.save(theUserLogin);
    }

    @Transactional
    @Override
    public void deleteById(String theId) {
        userLoginDAO.deleteById(theId);
    }
}
