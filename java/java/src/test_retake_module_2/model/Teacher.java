package test_retake_module_2.model;

public class Teacher extends People{
    private int idTeacher;

    public Teacher(int idTeacher, String name, String day, String sex, String phoneNumber) {
        super(name, day, sex, phoneNumber);
        this.idTeacher = idTeacher;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "idTeacher=" + idTeacher +
                super.toString() +
                '}';
    }
}
