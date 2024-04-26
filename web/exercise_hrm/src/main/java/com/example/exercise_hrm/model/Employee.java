package com.example.exercise_hrm.model;

import java.util.Date;

public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private Date birthday;
    private String address;
    private Date startDate;
    private Date endDate;
    private int salary;
    private int jobCode;
    private String nameJob;

    public Employee() {
    }

    public Employee(int id, String name, Date birthday, String address, Date startDate, Date endDate, int salary, int jobCode) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.jobCode = jobCode;
    }

    public Employee(String name, Date birthday, String address, Date startDate, Date endDate, int salary, int jobCode) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.jobCode = jobCode;
    }

    public Employee(int id, String name, Date birthday, String address, Date startDate, Date endDate, int salary, int jobCode, String nameJob) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.jobCode = jobCode;
        this.nameJob = nameJob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    @Override
    public int compareTo(Employee o) {
//        return Integer.compare(this.getId(), o.getId());
        return this.getName().compareTo(o.getName());
    }
}
