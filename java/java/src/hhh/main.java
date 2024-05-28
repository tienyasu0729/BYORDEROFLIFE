package hhh;

public class main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2); // true, cả hai biến đều tham chiếu đến cùng một đối tượng
    }
}
