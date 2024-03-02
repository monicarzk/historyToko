package com.historyToko.caringin.service;

import com.historyToko.caringin.dao.UserLoginDAO;
import com.historyToko.caringin.entity.UserLogin;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService{

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
    public UserLogin findByUsername(String theUsername) {
        return userLoginDAO.findByUsername(theUsername);
    }

    @Transactional
    @Override
    public UserLogin save(UserLogin theUserLogin) {
        return userLoginDAO.save(theUserLogin);
    }

    @Transactional
    @Override
    public void deleteByUsername(String theUsername) {
        userLoginDAO.deleteByUsername(theUsername);

    }
}
