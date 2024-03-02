package com.historyToko.caringin.service;

import com.historyToko.caringin.dao.HistoryRepository;
import com.historyToko.caringin.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public History findByDate(LocalDate theDate) {
        Optional<History> result = historyRepository.findById(theDate);

        History theHistory = null;

        if(result.isPresent()) {
            theHistory = result.get();
        }
        else {
            throw new RuntimeException("Did not find History date - " + theDate);
        }

        return theHistory;

    }

    @Override
    public History save(History theHistory) {
        return historyRepository.save(theHistory);
    }

    @Override
    public void deleteByDate(LocalDate theDate) {
        historyRepository.deleteById(theDate);

    }
}
