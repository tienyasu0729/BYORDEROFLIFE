import javax.usb.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Main {
//    public static void main(String[] args) {
//        UsbServices services = null;
//        try {
//            services = UsbHostManager.getUsbServices();
//        } catch (UsbException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            UsbHub rootHub = services.getRootUsbHub();
//            listDevices(rootHub);
//        } catch (UsbException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void listDevices(UsbHub hub) throws UsbException {
//        List<UsbDevice> devices = hub.getAttachedUsbDevices();
//        for (UsbDevice device : devices) {
//            System.out.println("Device Descriptor: " + device.getUsbDeviceDescriptor());
//            try {
//                System.out.println("Product Name: " + device.getProductString());
//            } catch (UnsupportedEncodingException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                System.out.println("Manufacturer Name: " + device.getManufacturerString());
//            } catch (UnsupportedEncodingException e) {
//                throw new RuntimeException(e);
//            }
//
//            if (device.isUsbHub()) {
//                listDevices((UsbHub) device);
//            }
//        }
//    }
//public static void main(String[] args) {
//    try {
//        // Sử dụng lệnh ADB để lấy thông tin thiết bị, bao gồm mã model
//        Process process = Runtime.getRuntime().exec("adb devices -l");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line;
//
//        // Đọc và in thông tin từ lệnh ADB
//        while ((line = reader.readLine()) != null) {
//            if (line.contains("model:")) {
//                int startIndex = line.indexOf("model:");
//                String model = line.substring(startIndex + 7);
//                System.out.println("Mã Model của điện thoại: " + model.trim());
//            }
//        }
//
//        // Đóng luồng đọc
//        reader.close();
//
//        // Chờ quá trình kết thúc
//        process.waitFor();
//    } catch (InterruptedException | IOException e) {
//        e.printStackTrace();
//    }
//}

//    public static void main(String[] args) {
//        try {
//            // Sử dụng lệnh ADB để lấy thông tin thiết bị, bao gồm mã model
//            Process process = Runtime.getRuntime().exec("adb devices -l");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//
//            // Đọc và in thông tin từ lệnh ADB
//            while ((line = reader.readLine()) != null) {
//                if (line.contains("model:")) {
//                    int startIndex = line.indexOf("model:");
//                    String modelPart = line.substring(startIndex + 6);
//                    String[] parts = modelPart.split("\\s+"); // Tách các phần bằng dấu cách
//                    String model = parts[0]; // Lấy phần đầu tiên
//                    System.out.println("Mã Model của điện thoại: " + model);
//                }
//            }
//
//            // Đóng luồng đọc
//            reader.close();
//
//            // Chờ quá trình kết thúc
//            process.waitFor();
//        } catch (InterruptedException | IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {
            // Sử dụng lệnh ADB để lấy thông tin thiết bị, bao gồm mã model
            Process process = Runtime.getRuntime().exec("adb shell getprop ro.product.model");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Đọc và in thông tin từ lệnh ADB
            while ((line = reader.readLine()) != null) {
                System.out.println("Mã Model của điện thoại: " + line.trim());
            }

            // Đóng luồng đọc
            reader.close();

            // Chờ quá trình kết thúc
            process.waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}