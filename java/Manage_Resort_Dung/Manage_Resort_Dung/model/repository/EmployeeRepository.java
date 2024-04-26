package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Employee;
import model.entity.Level;
import model.entity.Role;
import model.entity.WorkingParts;

public class EmployeeRepository {
    ArrayList<Employee> Employees=new ArrayList<>();
    LevelRepository levelRepository=new LevelRepository();
    RoleRepository roleRepository=new RoleRepository();
    WorkingPartRepository workingPartRepository=new WorkingPartRepository();
    public ArrayList<Employee> read() throws Exception{
        Employees.clear();
        FileReader fr= new FileReader("D://Hoc_them/resort/database/Employee.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            int employeeId=Integer.parseInt(result.split(",")[0]);
            String employeeName=result.split(",")[1];
            String birthday=result.split(",")[2];
            String identifyNumber=result.split(",")[3];
            String phoneNumber=result.split(",")[4];
            String email=result.split(",")[5];
            int levelId=Integer.parseInt(result.split(",")[6]);
            Level level=levelRepository.getLevelById(levelId);
            int roleId=Integer.parseInt(result.split(",")[7]);
            Role role=roleRepository.getRoleById(roleId);
            int workingPartId=Integer.parseInt(result.split(",")[8]);
            WorkingParts workingParts=workingPartRepository.getWorkingPartsById(workingPartId);
            Employee Employee2=new Employee(employeeId, employeeName, birthday, identifyNumber, phoneNumber, email, level, role, workingParts);
            Employees.add(Employee2);
        }
        br.close();
        fr.close();
        return Employees;
    }

    public void write() throws Exception{
        FileWriter fw=new FileWriter("D://Hoc_them/resort/database/Employee.txt");
        String empString="";
        for (Employee Employee : Employees) {
            empString += Employee.getEmployeeId()+"," +Employee.getEmployeeName()+","+Employee.getBirthday()+","+Employee.getIdentifyNumber()+","+Employee.getPhoneNumber()+","+Employee.getEmail()+","+Employee.getLevel().getId()+","+Employee.getRole().getId()+","+Employee.getWorkingParts().getId()+"\n";
        }
        fw.write(empString);
        fw.close();
    }

    public void add(Employee Employee)throws Exception{
        read();
        Employees.add(Employee);
        write();
    }

    public ArrayList<Employee> getAllEmployee()throws Exception{
        return read();
    }

    public Employee getEmployeeById(int id) throws Exception{
        read();
        for (Employee Employee : Employees) {
            if(Employee.getEmployeeId()==id){
                return Employee;
            }
        }
        return null;
    }

    public void editEmployee(int id, Employee employee)throws Exception{
        ArrayList<Employee> Employees=getAllEmployee();
        for (Employee Employee : Employees) {
            if(Employee.getEmployeeId()==id){
                Employees.remove(Employee);
            }
        }
        Employees.add(employee);
        write();
    }

    public void deleteEmployee(int id)throws Exception{
        ArrayList<Employee> Employees=getAllEmployee();
        for (Employee Employee : Employees) {
            if(Employee.getEmployeeId()==id){
                Employees.remove(Employee);
            }
        }
        write();
    }
}
