package org.muhikira.recruitementservice.service;

import org.muhikira.recruitementservice.model.JobApplication;
import org.muhikira.recruitementservice.repository.RecruitmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentService {

    @Autowired
    private RecruitmentRepository recruitmentRepository;

    public List<JobApplication> getAllJobs() {
        return recruitmentRepository.findAll();
    }

    public JobApplication applyForJob(JobApplication jobApplication) {
        return recruitmentRepository.save(jobApplication);
    }
}
