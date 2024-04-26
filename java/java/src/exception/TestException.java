package exception;

import java.util.*;

class Student{
    int id;
    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

//    @Override
//    public int compareTo(Student o) {
//        if (this.id < o.id)return 1;
//        else if (this.id > o.id)return -1;
//        else return 0;
//    }

}

public class TestException {
    private static LinkedList<Student> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        linkedList.add(new Student(11));
        linkedList.add(new Student(6));
        linkedList.add(new Student(8));
        linkedList.add(new Student(5));
//        Collections.sort(linkedList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o2, Student o1) {
//                if(o1.id < o2.id)return 1;
//                else if(o1.id > o2.id) return -1;
//                else return 0;
//            }
//        });
        Collections.sort(linkedList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.id < o2.id)return 1;
                else if (o1.id > o2.id) return -1;
                else return 0;
            }
        });
        System.out.println(linkedList);
    }
}
