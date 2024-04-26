package test;

public class demoMethod {
    private final int id;
    private final String name;
    private static String school = "codegym";

    public demoMethod (int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static void change(){
        school = "Đại học FPT";
    }
    private void display () {
        System.out.println(id + " " + name + " " + school);
    }


    public static void main(String[] args) {
        demoMethod student = new demoMethod(1, "tiến");
        demoMethod student2 = new demoMethod(2, "tiến2");
        demoMethod student3 = new demoMethod(3, "tiến3");
        change();
        student.display();
        student2.display();
        student3.display();
    }

}
