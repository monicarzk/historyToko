package com.history_toko.toko.service;

import com.history_toko.toko.dao.HistoryDAO;
import com.history_toko.toko.entity.History;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private HistoryDAO historyDAO;

    @Autowired
    public HistoryServiceImpl(HistoryDAO theHistoryDAO) {
        historyDAO = theHistoryDAO;
    }

    @Override
    public List<History> findAll() {
        return historyDAO.findAll();
    }

    @Override
    public History findById(int theId) {
        return historyDAO.findById(theId);
    }

    @Transactional
    @Override
    public History save(History theHistory) {
        return historyDAO.save(theHistory);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        historyDAO.deleteById(theId);

    }
}
