package com.example.quan_ly_nhan_su.model;

public class Job {
    private int jobId;
    private String jobName;
    private int highestSalary;
    private int lowestSalary;

    public Job(int jobId, String jobName, int highestSalary, int lowestSalary) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.highestSalary = highestSalary;
        this.lowestSalary = lowestSalary;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getHighestSalary() {
        return highestSalary;
    }

    public void setHighestSalary(int highestSalary) {
        this.highestSalary = highestSalary;
    }

    public int getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(int lowestSalary) {
        this.lowestSalary = lowestSalary;
    }
}
