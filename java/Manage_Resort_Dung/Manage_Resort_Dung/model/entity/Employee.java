package model.entity;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String birthday;
    private String identifyNumber;
    private String phoneNumber;
    private String email;
    private Level level;
    private Role role;
    private WorkingParts workingParts;
    
    public Employee(int employeeId, String employeeName, String birthday, String identifyNumber,
            String phoneNumber, String email, Level level, Role role, WorkingParts workingParts) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.identifyNumber = identifyNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.role = role;
        this.workingParts = workingParts;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getIdentifyNumber() {
        return identifyNumber;
    }
    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
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
    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public WorkingParts getWorkingParts() {
        return workingParts;
    }
    public void setWorkingParts(WorkingParts workingParts) {
        this.workingParts = workingParts;
    }
    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", birthday="
                + birthday + ", identifyNumber=" + identifyNumber + ", phoneNumber=" + phoneNumber + ", email=" + email
                + ", level=" + level.getLevelName() + ", role=" + role.getRoleName() + ", workingParts=" + workingParts.getWorkingPartsName() + "]";
    }
}
