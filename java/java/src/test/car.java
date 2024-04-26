package test;

public class car {
    private String name;
    private int engine;

    private static int numberOfCars;

    public car(String name, int engine){
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }

    public static void main(String[] args) {
        car car1 = new car("vios", 150);
        System.out.println(car.numberOfCars);
        car car2 = new car("vios", 160);
        System.out.println(car.numberOfCars);
    }
}
