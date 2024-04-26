package com.example.quan_ly_nhan_su.repository.impl;

import com.example.quan_ly_nhan_su.model.Employee;
import com.example.quan_ly_nhan_su.repository.IEployeeRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmployeeRepository implements IEployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private List<Employee> employeeList = new ArrayList<>();

    private static final String ADD_NEW_EMPLOYEE = "insert into employee(name,birthday,address,startDate,endDate,salary,jobid) values (?,?,?,?,?,?,?)";
    @Override
    public void addNewEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(ADD_NEW_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setDate(2, Date.valueOf(employee.getBirthday()));
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setDate(4, Date.valueOf(employee.getStartDate()));
            preparedStatement.setDate(5, Date.valueOf(employee.getEndDate()));
            preparedStatement.setInt(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getJobId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public List<Employee> listEmployee() {
        List<Employee> employees = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                int id = resultSet.getInt("employeeId");
                String name = resultSet.getString("name");
                LocalDate birthDate = resultSet.getDate("birthday").toLocalDate();
                String address = resultSet.getString("address");
                LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
                LocalDate endDate = resultSet.getDate("endDate").toLocalDate();
                int salary = resultSet.getInt("salary");
                int jobId = resultSet.getInt("jobid");
                employees.add(new Employee(id,name,birthDate,address,startDate,endDate,salary,jobId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public List<Employee> findByNameOfJob() {
        return null;
    }

    @Override
    public List<Employee> findByStartDateOfJob() {
        return null;
    }

    @Override
    public List<Employee> findByEndDateOfJob() {
        return null;
    }
}
