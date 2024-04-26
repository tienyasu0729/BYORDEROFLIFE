package model;

import java.util.Date;

public class Employee {
    private String id;
    private String account;
    private Date WorkStartingDate;
    private Float ProductivityScore;
    private int MonthlyIncome;
    private int RewardSalary;

    public Employee(String id, String account, Date workStartingDate, Float productivityScore, int monthlyIncome, int rewardSalary) {
        this.id = id;
        this.account = account;
        WorkStartingDate = workStartingDate;
        ProductivityScore = productivityScore;
        MonthlyIncome = monthlyIncome;
        RewardSalary = rewardSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getWorkStartingDate() {
        return WorkStartingDate;
    }

    public void setWorkStartingDate(Date workStartingDate) {
        WorkStartingDate = workStartingDate;
    }

    public Float getProductivityScore() {
        return ProductivityScore;
    }

    public void setProductivityScore(Float productivityScore) {
        ProductivityScore = productivityScore;
    }

    public int getMonthlyIncome() {
        return MonthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        MonthlyIncome = monthlyIncome;
    }

    public int getRewardSalary() {
        return RewardSalary;
    }

    public void setRewardSalary(int rewardSalary) {
        RewardSalary = rewardSalary;
    }
    public void CalMonthlyIncome(){
        this.MonthlyIncome = 
    }
    public void CalReward(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", WorkStartingDate=" + WorkStartingDate +
                ", ProductivityScore=" + ProductivityScore +
                ", MonthlyIncome=" + MonthlyIncome +
                ", RewardSalary=" + RewardSalary +
                '}';
    }
}
