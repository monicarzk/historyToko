package com.historyToko.caringin.dao;

import com.historyToko.caringin.entity.UserLogin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserLoginDAOJpaImpl implements UserLoginDAO {
    private EntityManager entityManager;

    @Autowired
    public UserLoginDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<UserLogin> findAll() {

        TypedQuery<UserLogin> theQuery = entityManager.createQuery("from UserLogin", UserLogin.class);

        List<UserLogin> userLogins = theQuery.getResultList();

        return userLogins;
    }

    @Override
    public UserLogin findByUsername(String theUsername) {

        UserLogin theUserLogin = entityManager.find(UserLogin.class, theUsername);

        return theUserLogin;
    }

    @Override
    public UserLogin save(UserLogin theUserLogin) {

        UserLogin dbUserLogin = entityManager.merge(theUserLogin);

        return dbUserLogin;
    }

    @Override
    public void deleteByUsername(String theUsername) {

        UserLogin theUserLogin = entityManager.find(UserLogin.class, theUsername);

        entityManager.remove(theUserLogin);
    }
}
