package com.history_toko.toko.dao;

import com.history_toko.toko.entity.History;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryDAOJpaImpl implements HistoryDAO {

    private EntityManager entityManager;

    @Autowired
    public HistoryDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<History> findAll() {

        TypedQuery<History> theQuery = entityManager.createQuery("from History", History.class);

        List<History> histories = theQuery.getResultList();

        return histories;
    }
}
