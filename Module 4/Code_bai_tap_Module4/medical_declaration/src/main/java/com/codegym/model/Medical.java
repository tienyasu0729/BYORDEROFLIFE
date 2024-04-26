package com.codegym.model;

import java.util.Date;

public class Medical {
    private String fullName;
    private int yearOfBirth;
    private int gender;
    private String id;
    private String travelInformation;
    private String vehicleNumber;
    private int terribleNumber;
    private Date departureDay;
    private Date endDate;
    private String whereWentTo;
    private String address;
    private String phoneNumber;
    private String email;
    private  String symptom;

    public Medical() {
    }

    public Medical(String fullName, int yearOfBirth, int gender, String id, String travelInformation, String vehicleNumber, int terribleNumber, Date departureDay, Date endDate, String whereWentTo, String address, String phoneNumber, String email, String symptom) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.id = id;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.terribleNumber = terribleNumber;
        this.departureDay = departureDay;
        this.endDate = endDate;
        this.whereWentTo = whereWentTo;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.symptom = symptom;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getTerribleNumber() {
        return terribleNumber;
    }

    public void setTerribleNumber(int terribleNumber) {
        this.terribleNumber = terribleNumber;
    }

    public Date getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Date departureDay) {
        this.departureDay = departureDay;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getWhereWentTo() {
        return whereWentTo;
    }

    public void setWhereWentTo(String whereWentTo) {
        this.whereWentTo = whereWentTo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
