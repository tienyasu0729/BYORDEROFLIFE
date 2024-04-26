package ss10_list_set;

import ss9_mvc.model.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(2);
//        arrayList.add(1);
//        for (Integer e : arrayList) {
//            System.out.println(e);
//        }
//        ArrayList<Student> studentList = new ArrayList<>();
//        studentList.add(new Student(1,"chanh","QN"));
//        studentList.add(new Student(2,"chanh2","QN"));
//        for (int i = 0; i <studentList.size() ; i++) {
//            System.out.println(studentList.get(i));
//        }
//        LinkedList<Student> studentList1 = new LinkedList<>();

//        LinkedHashSet<Student> studentHashSet = new LinkedHashSet<>();
//        studentHashSet.add(new Student(5,"chanh5","QN"));
//        studentHashSet.add(new Student(5,"chanh5","QN222"));
//        studentHashSet.add(new Student(1,"chanh1","QN"));
//        studentHashSet.add(new Student(3,"chanh3","QN"));
//        studentHashSet.add(new Student(2,"chanh2","QN"));
//        studentHashSet.add(new Student(4,"chanh4","QN"));
//        for (Student s: studentHashSet) {
//            System.out.println(s);
//        }
//        TreeSet<Student> studentTreeSet = new TreeSet<>();
//        studentTreeSet.add(new Student(5,"chanh5","QN"));
//        studentTreeSet.add(new Student(5,"chanh5","QN222"));
//        studentTreeSet.add(new Student(1,"chanh1","QN"));
//        studentTreeSet.add(new Student(3,"chanh3","QN"));
//        studentTreeSet.add(new Student(2,"chanh2","QN"));
//        studentTreeSet.add(new Student(4,"chanh4","QN"));
//        for (Student s: studentTreeSet) {
//            System.out.println(s);
//        }
        Student student1 = new Student(1,"chanh","DN");
        Student student2 = new Student(1,"chanh","DN");
        System.out.println(student1.equals(student2));
    }

}
