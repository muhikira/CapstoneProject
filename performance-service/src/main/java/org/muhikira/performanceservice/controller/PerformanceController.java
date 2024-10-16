package org.muhikira.performanceservice.controller;

import org.muhikira.performanceservice.model.PerformanceReview;
import org.muhikira.performanceservice.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping
    public List<PerformanceReview> getAllReviews() {
        return performanceService.getAllReviews();
    }

    @PostMapping
    public PerformanceReview addReview(@RequestBody PerformanceReview review) {
        return performanceService.addReview(review);
    }
}