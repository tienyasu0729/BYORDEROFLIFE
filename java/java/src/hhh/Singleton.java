package hhh;

public class Singleton {
    private static Singleton instance;

    // Phương thức khởi tạo riêng để ngăn chặn việc tạo thể hiện từ bên ngoài
    private Singleton() {}

    // Phương thức công khai để truy cập thể hiện duy nhất của lớp
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
