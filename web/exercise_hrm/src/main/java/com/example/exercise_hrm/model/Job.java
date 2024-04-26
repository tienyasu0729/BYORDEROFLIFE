package com.example.exercise_hrm.model;

public class Job {
    private int jobCode;
    private String nameJob;
    private int minSalary;
    private int maxSalary;

    public Job(int jobCode, String nameJob, int minSalary, int maxSalary) {
        this.jobCode = jobCode;
        this.nameJob = nameJob;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public int getJobCode() {
        return jobCode;
    }

    public void setJobCode(int jobCode) {
        this.jobCode = jobCode;
    }

    public String getNameJob() {
        return nameJob;
    }

    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
}
