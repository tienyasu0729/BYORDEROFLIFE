package FuramaResort.Model;

public class Employee extends People implements Comparable<Employee>{
    private String skills;

    public Employee(String cccd, String name, int age, String skills) {
        super(cccd, name, age);
        this.skills = skills;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return String.format("EmployeeSet ( CCCD: %s, Name: %s, Age: %s, Skill: %s )\n", super.getCccd(),super.getName(), super.getAge(), skills );
    }


    // dùng cho Set
//    @Override
//    public int compareTo(EmployeeSet employee) {
//        char[] charThisGetCCCD = this.getCccd().toCharArray();
//        char[] charEmployeeCCCD = employee.getCccd().toCharArray();
//        int returnCCCD = 0;
//        for (int i = 0; i < 12; i++) {
//            if (Character.getNumericValue(charThisGetCCCD[i]) > Character.getNumericValue(charEmployeeCCCD[i])){
//                returnCCCD = 1;
//                break;
//            } else if (Character.getNumericValue(charThisGetCCCD[i]) < Character.getNumericValue(charEmployeeCCCD[i])){
//                returnCCCD = -1;
//                break;
//            }
//        }
//        return returnCCCD;
//    }



    // dùng cho List
    @Override
    public int compareTo(Employee employee) {
        return this.getAge() - employee.getAge();
    }

    @Override
    public void move() {
        System.out.println("Move on foot");
    }
}
