package com.history_toko.toko.service;

import com.history_toko.toko.dao.UserLoginRepository;
import com.history_toko.toko.entity.UserLogin;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.String;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UserLoginService {

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
    public UserLogin findById(String theId) {
        Optional<UserLogin> result = userLoginRepository.findById(theId);

        UserLogin theUserLogin = null;

        if (result.isPresent()) {
            theUserLogin = result.get();
        }
        else {
            throw new RuntimeException("Did not find user_login id - " + theId);
        }

        return theUserLogin;
    }

    @Override
    public UserLogin save(UserLogin theUserLogin) {
        return userLoginRepository.save(theUserLogin);
    }

    @Override
    public void deleteById(String theId) {
        userLoginRepository.deleteById(theId);
    }
}
