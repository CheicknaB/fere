package org.fere.controllers;

import org.fere.entities.Performance;
import org.fere.entities.Performance;
import org.fere.services.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Performance>> findAll() {
        List<Performance> performances = performanceService.find();
        return new ResponseEntity<>(performances, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Performance> savePerformance(@RequestBody Performance panierVente) {
        Performance savedPanier = performanceService.save(panierVente);
        return new ResponseEntity<>(savedPanier, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Performance> findPerformanceById(@PathVariable Long id) {
        Performance performance = performanceService.findById(id);
        return new ResponseEntity<>(performance, HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deletePerformanceById(@PathVariable Long id) {
            performanceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Performance> updatePerformance(@RequestBody Performance performance) {
        performanceService.update(performance);
        return new ResponseEntity<>(performance, HttpStatus.OK);
    }
}

