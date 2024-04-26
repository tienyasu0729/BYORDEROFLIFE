package com.example.quan_ly_nhan_su.repository.impl;

import com.example.quan_ly_nhan_su.model.Job;
import com.example.quan_ly_nhan_su.repository.IJobRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobRepository implements IJobRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static String LIST_JOB = "select * from job";
    @Override
    public List<Job> list() {
        List<Job> jobList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(LIST_JOB);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int jobId = resultSet.getInt("jobid");
                String name = resultSet.getString("jobname");
                int highestSalary = resultSet.getInt("highestSalary");
                int lowestSalary = resultSet.getInt("lowestSalary");
                jobList.add(new Job(jobId, name, highestSalary, lowestSalary));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jobList;
    }
}
