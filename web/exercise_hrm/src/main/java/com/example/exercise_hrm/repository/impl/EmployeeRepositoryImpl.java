package com.example.exercise_hrm.repository.impl;

import com.example.exercise_hrm.model.Employee;
import com.example.exercise_hrm.repository.EmployeeRepository;
import com.example.exercise_hrm.util.ComparatorUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.example.exercise_hrm.util.ConnectionUtil.getConnection;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String SELECT_ALL = "select * from staff join job on staff.job_id = job.job_id;";
    private static final String SELECT_ALL_BY_NAME_JOB = "select * from staff join job on staff.job_id = job.job_id where job_name like ?";
    private static final String INSERT_EMPLOYEE = "INSERT INTO staff(name, date_birth, address, day_start, day_end, " +
            "salary, job_id) value (?,?, ?,?,?,?,?);";
    private static final String UPDATE_BY_ID = "update staff set name =?, date_birth = ?, address =?, date_start = ?," +
            " date_end = ?, salary =?, job_id = ? where id = ?";

    private static final String DELETE_EMPLOYEE_ID = "delete from staff where id = ?";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from staff where id =?";
    private static final String SELECT_EMPLOYEE_BY_DATE = "SELECT * FROM staff join job on staff.job_id = job.job_id WHERE day_start BETWEEN ? " +
            "AND ? AND day_end BETWEEN ? AND ?;";

    @Override
    public void add(Employee employee) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setDate(4, new java.sql.Date(employee.getStartDate().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(employee.getEndDate().getTime()));
            preparedStatement.setInt(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getJobCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setDate(4, new java.sql.Date(employee.getStartDate().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(employee.getEndDate().getTime()));
            preparedStatement.setInt(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getJobCode());
            preparedStatement.setInt(8, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date birthday = resultSet.getDate("date_birth");
                String address = resultSet.getString("address");
                Date startDate = resultSet.getDate("day_start");
                Date endDate = resultSet.getDate("day_end");
                int salary = resultSet.getInt("salary");
                int jobCode = resultSet.getInt("job_id");
                String jobName = resultSet.getString("job_name");
                list.add(new Employee(id, name, birthday, address, startDate, endDate, salary, jobCode, jobName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list.sort(new ComparatorUtil<>());
        return list;
    }

    @Override
    public Employee findById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Date birthday = resultSet.getDate("date_birth");
                String address = resultSet.getString("address");
                Date startDate = resultSet.getDate("day_start");
                Date endDate = resultSet.getDate("day_end");
                int salary = resultSet.getInt("salary");
                int jobCode = resultSet.getInt("job_id");
                return new Employee(id, name, birthday, address, startDate, endDate, salary, jobCode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_ID)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public List<Employee> findByNameJob(String jobName) {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_NAME_JOB)) {
            preparedStatement.setString(1, "%" + jobName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date birthday = resultSet.getDate("date_birth");
                String address = resultSet.getString("address");
                Date startDate = resultSet.getDate("day_start");
                Date endDate = resultSet.getDate("day_end");
                int salary = resultSet.getInt("salary");
                int jobCode = resultSet.getInt("job_id");
                employeeList.add(new Employee(id, name, birthday, address, startDate, endDate, salary, jobCode, jobName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Employee> search(Date begin, Date end) {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_DATE)) {
            preparedStatement.setDate(1, new java.sql.Date(begin.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(end.getTime()));
            preparedStatement.setDate(3, new java.sql.Date(begin.getTime()));
            preparedStatement.setDate(4, new java.sql.Date(end.getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date birthday = resultSet.getDate("date_birth");
                String address = resultSet.getString("address");
                Date startDate = resultSet.getDate("day_start");
                Date endDate = resultSet.getDate("day_end");
                int salary = resultSet.getInt("salary");
                int jobCode = resultSet.getInt("job_id");
                String jobName = resultSet.getString("job_name");
                employeeList.add(new Employee(id, name, birthday, address, startDate, endDate, salary, jobCode, jobName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
