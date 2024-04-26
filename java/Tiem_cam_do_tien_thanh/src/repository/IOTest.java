    package repository;

    import model.*;

    import java.io.*;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    public class IOTest {
        public static List<Phone> phonesRepository = new ArrayList<>();
        public static List<Laptop> laptopsRepository = new ArrayList<>();
        public static List<Vehicle> vehiclesRepository = new ArrayList<>();
        private static String filePhone = "C:\\codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Phone";
        private static String fileLaptop = "C:\\codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Laptop";
        private static String fileVehicle = "C:\\codegym\\text\\java\\Tiem_cam_do_tien_thanh\\src\\data\\Vehicle";
        public static void writePhone() {
            try {
                FileWriter fileWriter = new FileWriter(filePhone);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Phone phone : phonesRepository) {
                    String phoneText = phone.toString();
                    bufferedWriter.write(phoneText);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void writeLaptop() {
            try {
                FileWriter fileWriter = new FileWriter(fileLaptop);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Laptop laptop : laptopsRepository) {
                    // Ghi thông tin của từng đối tượng Phone vào file dưới dạng văn bản
                    String laptopText = laptop.toString();
                    bufferedWriter.write(laptopText);
                    bufferedWriter.newLine(); // Xuống dòng sau khi ghi mỗi đối tượng
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void writeVehicle() {
            try {
                FileWriter fileWriter = new FileWriter(fileVehicle);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Vehicle vehicle : vehiclesRepository) {
                    // Ghi thông tin của từng đối tượng Phone vào file dưới dạng văn bản
                    String vehicleText = vehicle.toString();
                    bufferedWriter.write(vehicleText);
                    bufferedWriter.newLine(); // Xuống dòng sau khi ghi mỗi đối tượng
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void readPhone() {
            try {
                FileReader fileReader = new FileReader(filePhone);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    // Extract individual values from parts array
                    int id = Integer.parseInt(parts[0].split("\\.")[0].trim());
                    String name = parts[0].split(": ")[1].trim();
                    String cccd = parts[1].split(":")[1].trim();
                    int price = Integer.parseInt(parts[2].split(":")[1].trim());
                    String manufacturerPhone = parts[3].split(":")[1].trim();
                    String namePhone = parts[4].split(":")[1].trim();
                    String pawnDateStr = parts[5].split(": ")[1].trim();
                    Date pawnDate = null;
                    try {
                        pawnDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(pawnDateStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String phoneNumber = parts[6].split(":")[1].trim();
                    String password = parts[7].split(":")[1].trim();
                    String status = parts[8].split(":")[1].trim();
                    String note = parts[9].split(":")[1].trim();

                    // Create and return the Phone object
                    phonesRepository.add(new Phone(id, name, cccd, price, phoneNumber, pawnDate, note, manufacturerPhone, namePhone, password, status));
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void readLaptop() {
            try {
                FileReader fileReader = new FileReader(fileLaptop);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    // Extract individual values from parts array
                    int id = Integer.parseInt(parts[0].split("\\.")[0].trim());
                    String name = parts[0].split(": ")[1].trim();
                    String cccd = parts[1].split(":")[1].trim();
                    int price = Integer.parseInt(parts[2].split(":")[1].trim());
                    String manufacturerLaptop = parts[3].split(":")[1].trim();
                    String nameLaptop = parts[4].split(":")[1].trim();
                    String pawnDateStr = parts[5].split(": ")[1].trim();
                    Date pawnDate = null;
                    try {
                        pawnDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(pawnDateStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String phoneNumber = parts[6].split(":")[1].trim();
                    String password = parts[7].split(":")[1].trim();
                    String status = parts[8].split(":")[1].trim();
                    String note = parts[9].split(":")[1].trim();

                    // Create and return the Phone object
                    laptopsRepository.add(new Laptop(id, name, cccd, price, phoneNumber, pawnDate, note, manufacturerLaptop, nameLaptop, password, status));
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static void readVehicle() {
            try {
                FileReader fileReader = new FileReader(fileVehicle);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    // Extract individual values from parts array
                    int id = Integer.parseInt(parts[0].split("\\.")[0].trim());
                    String name = parts[0].split(": ")[1].trim();
                    String cccd = parts[1].split(":")[1].trim();
                    int price = Integer.parseInt(parts[2].split(":")[1].trim());
                    String manufacturerVehicle = parts[3].split(":")[1].trim();
                    String nameVehicle = parts[4].split(":")[1].trim();
                    String pawnDateStr = parts[5].split(": ")[1].trim();
                    Date pawnDate = null;
                    try {
                        pawnDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(pawnDateStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String phoneNumber = parts[6].split(":")[1].trim();
                    String licensePlate = parts[7].split(":")[1].trim();
                    String status = parts[8].split(":")[1].trim();
                    String note = parts[9].split(":")[1].trim();

                    // Create and return the Phone object
                    vehiclesRepository.add(new Vehicle(id, name, cccd, price, phoneNumber, pawnDate, note, manufacturerVehicle, nameVehicle, licensePlate, status));
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
