package model.service;

import java.util.ArrayList;

import model.entity.Employee;
import model.entity.Level;
import model.entity.Role;
import model.entity.WorkingParts;
import model.repository.EmployeeRepository;
import model.repository.LevelRepository;
import model.repository.RoleRepository;
import model.repository.WorkingPartRepository;

public class EmployeeService {
    EmployeeRepository employeeRepository=new EmployeeRepository();
    LevelRepository levelRepository=new LevelRepository();
    RoleRepository roleRepository=new RoleRepository();
    WorkingPartRepository workingPartRepository=new WorkingPartRepository();

    public ArrayList<Level> getAllLevels()throws Exception{
        return levelRepository.getAllLevels();
    }

    public Level getLevelById(int id)throws Exception{
        return levelRepository.getLevelById(id);
    }

    public ArrayList<Role> getAllRoles() throws Exception{
        return roleRepository.getAllRoles();
    }

    public Role getRoleById(int id)throws Exception{
        return roleRepository.getRoleById(id);
    }

    public ArrayList<WorkingParts> getAllWorkingParts() throws Exception{
        return workingPartRepository.getAllWorkingParts();
    }

    public WorkingParts getWorkingPartById(int id)throws Exception{
        return workingPartRepository.getWorkingPartsById(id);
    }

    public void addEmployee(Employee employee)throws Exception{
        employeeRepository.add(employee);
    }

    public ArrayList<Employee> getAllEmployees() throws Exception{
        return employeeRepository.getAllEmployee();
    }

    public Employee getEmployeeById(int id)throws Exception{
        return employeeRepository.getEmployeeById(id);
    }

}
