package com.history_toko.toko.dao;

import com.history_toko.toko.entity.UserLogin;
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

        List<UserLogin> userlogins = theQuery.getResultList();

        return userlogins;
    }

    @Override
    public UserLogin findById(String theId) {

        UserLogin theUserLogin = entityManager.find(UserLogin.class, theId);

        return theUserLogin;
    }

    @Override
    public UserLogin save(UserLogin theUserLogin) {

        UserLogin dbUserLogin = entityManager.merge(theUserLogin);

        return dbUserLogin;
    }

    @Override
    public void deleteById(String theId) {

        UserLogin theUserLogin = entityManager.find(UserLogin.class, theId);

        entityManager.remove(theUserLogin);

    }
}
