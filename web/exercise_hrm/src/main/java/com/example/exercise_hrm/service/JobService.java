package com.example.exercise_hrm.service;

import com.example.exercise_hrm.model.Job;

import java.util.List;

public interface JobService {
    Job findById(int jobCode);

    List<Job> findAll();
}
