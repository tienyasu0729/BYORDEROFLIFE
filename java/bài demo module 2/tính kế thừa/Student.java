package inheritance;

public class Student extends Person {
    private static String school="CodeGym";
    private int point;

    public Student() {
        System.out.println("constructor con");
    }

    public Student(int id, String name, String address, int point) {
        super(id, name, address);
        this.point = point;
    }
    // phương thức đang ghi đè lại method của cha
    @Override
    public void howToGo(){
        System.out.println("sinh viên đi học bằng xe máy");
    }

    @Override
    public String toString() {
        return "Sinh viên{" +
                "point=" + point +
                ", id=" + id +
                '}';
    }
    public void study(){
        System.out.println("sinh viên đang học");
    }
}
