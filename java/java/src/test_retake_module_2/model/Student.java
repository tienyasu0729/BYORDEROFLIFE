package test_retake_module_2.model;

public class Student extends People{
    private int idStudent;
    private int idClass;

    public Student(int idStudent, String name, String day, String sex, String phoneNumber, int idClass) {
        super(name, day, sex, phoneNumber);
        this.idStudent = idStudent;
        this.idClass = idClass;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",idStudent,super.getName(),super.getDay(),super.getSex(),super.getPhoneNumber(),idClass);
    }
}
