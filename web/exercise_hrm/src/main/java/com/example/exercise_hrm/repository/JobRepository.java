package com.example.exercise_hrm.repository;

import com.example.exercise_hrm.model.Job;

import java.util.List;

public interface JobRepository {
    Job findById(int jobCode);

    List<Job> findAll();
}
