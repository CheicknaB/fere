package org.fere.services;

import org.fere.entities.Performance;
import org.fere.repositories.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;
    public List<Performance> find(){
        return performanceRepository.findAll();
    }

    public Performance save(Performance produit){
        return performanceRepository.save(produit);
    }

    public void deleteById(Long id) {
        performanceRepository.deleteById(id);
    }
    public Performance findById(Long id) {
        Optional<Performance> performance = performanceRepository.findById(id);
        return performance.orElse(null);
    }
    public Performance update(Performance produit) {
            return performanceRepository.save(produit);
    }
}
