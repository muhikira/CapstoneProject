package org.muhikira.recruitementservice.controller;

import org.muhikira.recruitementservice.model.JobApplication;
import org.muhikira.recruitementservice.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment")
public class RecruitmentController {

    @Autowired
    private RecruitmentService recruitmentService;

    @GetMapping("/jobs")
    public List<JobApplication> getAllJobs() {
        return recruitmentService.getAllJobs();
    }

    @PostMapping("/apply")
    public JobApplication applyForJob(@RequestBody JobApplication jobApplication) {
        return recruitmentService.applyForJob(jobApplication);
    }
}