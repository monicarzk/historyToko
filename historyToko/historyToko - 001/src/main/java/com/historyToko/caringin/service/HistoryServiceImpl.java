package com.historyToko.caringin.service;

import com.historyToko.caringin.dao.HistoryDAO;
import com.historyToko.caringin.entity.History;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public History findByDate(LocalDate theDate) {
        return historyDAO.findByDate(theDate);
    }

    @Transactional
    @Override
    public History save(History theHistory) {
        return historyDAO.save(theHistory);
    }

    @Transactional
    @Override
    public void deleteByDate(LocalDate theDate) {
        historyDAO.deleteByDate(theDate);

    }
}
