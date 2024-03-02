package com.historyToko.caringin.service;

import com.historyToko.caringin.dao.UserLoginRepository;
import com.historyToko.caringin.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UserLoginService{

    private UserLoginRepository userLoginRepository;

    @Autowired
    public UserLoginServiceImpl(UserLoginRepository theUserLoginRepository) {
        userLoginRepository = theUserLoginRepository;
    }

    @Override
    public List<UserLogin> findAll() {
        return userLoginRepository.findAll();
    }

    @Override
    public UserLogin findByUsername(String theUsername) {
        Optional<UserLogin> result = userLoginRepository.findById(theUsername);

        UserLogin theUserLogin = null;

        if (result.isPresent()) {
            theUserLogin = result.get();
        }
        else {
            throw new RuntimeException("Did not find user_login username - " + theUsername);
        }

        return theUserLogin;
    }

    @Override
    public UserLogin save(UserLogin theUserLogin) {
        return userLoginRepository.save(theUserLogin);
    }

    @Override
    public void deleteByUsername(String theUsername) {
        userLoginRepository.deleteById(theUsername);

    }
}
