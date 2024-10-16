package org.muhikira.performanceservice.repository;

import org.muhikira.performanceservice.model.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends JpaRepository<PerformanceReview, Long> {
}
