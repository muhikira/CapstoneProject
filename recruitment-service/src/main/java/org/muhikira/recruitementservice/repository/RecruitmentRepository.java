package org.muhikira.recruitementservice.repository;

import org.muhikira.recruitementservice.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends JpaRepository<JobApplication, Long> {
}