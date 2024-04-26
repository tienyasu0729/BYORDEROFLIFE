package com.example.exercise_hrm.service.impl;

import com.example.exercise_hrm.model.Job;
import com.example.exercise_hrm.repository.JobRepository;
import com.example.exercise_hrm.repository.impl.JobRepositoryImpl;
import com.example.exercise_hrm.service.JobService;

import java.util.List;

public class JobServiceImpl implements JobService {
    private JobRepository repository = new JobRepositoryImpl();
    @Override
    public Job findById(int jobCode) {
        return repository.findById(jobCode);
    }

    @Override
    public List<Job> findAll() {
        return repository.findAll();
    }
}
