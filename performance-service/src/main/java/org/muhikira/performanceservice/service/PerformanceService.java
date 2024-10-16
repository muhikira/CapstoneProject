package org.muhikira.performanceservice.service;

import org.muhikira.performanceservice.model.PerformanceReview;
import org.muhikira.performanceservice.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    public List<PerformanceReview> getAllReviews() {
        return performanceRepository.findAll();
    }

    public PerformanceReview addReview(PerformanceReview review) {
        return performanceRepository.save(review);
    }
}
