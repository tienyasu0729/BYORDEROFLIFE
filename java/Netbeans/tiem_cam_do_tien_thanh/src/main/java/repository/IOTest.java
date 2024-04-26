    package repository;

    import model.*;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.List;

    public class IOTest {
        public static List<Phone> phonesRepository = new ArrayList<>();
        public static List<Laptop> laptopsRepository = new ArrayList<>();
        public static List<Vehicle> vehiclesRepository = new ArrayList<>();
        public static void writePhone() {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Phone");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(phonesRepository);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void writeLaptop() {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Laptop");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(laptopsRepository);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void writeVehicle() {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Vehicle");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(vehiclesRepository);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void readPhone() {
            try {
                FileInputStream fileInputStream = new FileInputStream("C:\\Codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Phone");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                phonesRepository = (List<Phone>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        public static void readLaptop() {
            try {
                FileInputStream fileInputStream = new FileInputStream("C:\\Codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Laptop");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                laptopsRepository = (List<Laptop>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        public static void readVehicle() {
            try {
                FileInputStream fileInputStream = new FileInputStream("C:\\Codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Vehicle");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                vehiclesRepository = (List<Vehicle>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
