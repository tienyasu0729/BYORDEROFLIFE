public class dd {
    public static void main(String[] args) {
        int i = 10;
        Object o = i;
        o = 100;
        System.out.println(o);
        System.out.println(i);
        i = 99;
        System.out.println(o);
        System.out.println(i);
    }
}
