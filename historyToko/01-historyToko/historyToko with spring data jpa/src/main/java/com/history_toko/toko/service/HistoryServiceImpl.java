package com.history_toko.toko.service;

import com.history_toko.toko.dao.HistoryRepository;
import com.history_toko.toko.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {

    private HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository theHistoryRepository) {
        historyRepository = theHistoryRepository;
    }

    @Override
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public History findById(int theId) {
        Optional<History> result = historyRepository.findById(theId);

        History theHistory = null;

        if (result.isPresent()) {
            theHistory = result.get();
        }
        else {

            throw new RuntimeException("Did not find history id - " + theId);
        }

        return theHistory;
    }

    @Override
    public History save(History theHistory) {
        return historyRepository.save(theHistory);
    }

    @Override
    public void deleteById(int theId) {
        historyRepository.deleteById(theId);

    }
}
