abstract class Student {
    protected String fullName;
    protected String address;
    protected int age;
    protected double average;

    public Student(String fullName, String address, int age) {
        this.fullName = fullName;
        this.address = address;
        this.age = age;
        this.average = 0;
    }

    public abstract void calculateAverage();

    public void setAverage(double average) {
        this.average = average;
    }

    public void printInformation() {
        System.out.println("Họ và tên: " + fullName);
        System.out.println("Địa chỉ: " + address);
        System.out.println("Tuổi: " + age);
        System.out.println("Điểm trung bình: " + average);
    }
}