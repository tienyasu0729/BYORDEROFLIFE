package view;

import control.Company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Customer;

public class CompanyManagement extends Menu<String> {

    private Company company = new Company();

    static String[] options = new String[]{"Display all customers", "Search customer", "Add new customer", "Update phone, date of birth", "Write to file", "Delete customer by ID", "Exit"};

    public CompanyManagement() throws ParseException, IOException {
        super("----- Company Management System -----", options);
        loadCompanyDataFromFile("src/model/Customer.txt");
    }

    public void loadCompanyDataFromFile(String fileName) throws ParseException, IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 4) {
                    System.out.println("Invalid data format in line: " + line);
                    continue; // Bỏ qua dòng không hợp lệ và tiếp tục với dòng tiếp theo
                }

                String customerID = data[0].trim();
                String name = data[1].trim();
                String phone = data[2].trim();
                String dateOfBirth = data[3].trim();

                if (!isValidCustomerID(customerID)) {
                    System.out.println("Invalid customer ID in line: " + line);
                    System.out.print("File sai dữ liệu. ID phải có độ dài 2 -> 4 ký tự và bắt đầu bằng \"KH\". Vui lòng sửa lại file. ");
                    continue; // Bỏ qua dòng không hợp lệ và tiếp tục với dòng tiếp theo
                }

                if (!isValidName(name)) {
                    System.out.println("Invalid name in line: " + line);
                    System.out.println("Tên không hợp lệ vui lòng sửa lại file");
                    continue; // Bỏ qua dòng không hợp lệ và tiếp tục với dòng tiếp theo
                }

                if (!isValidPhone(phone)) {
                    System.out.println("Invalid phone number in line: " + line);
                    System.out.print("File sai dữ liệu. Số điện thoại phải có độ dài 10 ký tự và bắt đầu bằng \"09\".");
                    continue; // Bỏ qua dòng không hợp lệ và tiếp tục với dòng tiếp theo
                }

                if (!isValidDateOfBirth(dateOfBirth)) {
                    System.out.println("Invalid date of birth in line: " + line);
                    System.out.print("File sai dữ liệu. Vui lòng sửa file lại theo định dạng \"dd/MM/yyyy\" ");
                    continue; // Bỏ qua dòng không hợp lệ và tiếp tục với dòng tiếp theo
                }
                Customer customer = new Customer(customerID, name, phone, dateOfBirth);
                company.addCustomer(customer);
            }
            reader.close();
            System.out.println();
            System.out.println("Data loaded successfully from file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }


    ///hàm in ra danh sách khách hàng
    public void displayAllCustomers() {
        System.out.println("Danh sách khách hàng");
        System.out.println("-------------------------");
        company.printCustomerList();
        System.out.println("-------------------------");
        System.out.println("Tổng cộng: " + company.getCustomerList().size() + " khách hàng");
    }

    /////hàm nhập khách hàng
    public Customer addKhachhang(ArrayList<Customer> customerList) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập ID: ");
        String customerID = checkCustomerID(input);
        /////check id tồn tại hay chưa
        while (isIdExist(customerID, customerList)) {
            System.out.print("ID đã tồn tại. Vui lòng nhập lại ID khác: ");
            customerID = checkCustomerID(input);
        }
        System.out.print("Nhập Tên: ");
        String name = checkName(input);
        System.out.print("Nhập số điện thoại: ");
        String phone = checkPhone(input);
        /////check phone tồn tại hay chưa
        while (isPhoneExist(phone, customerList)) {
            System.out.println("Số điện thoại đã tồn tại. Vui lòng nhập lại.");
            phone = checkPhone(input);
        }
        System.out.print("Nhập vào ngày tháng năm sinh (dd/MM/yyyy): ");
        String dateOfBirth = checkDateOfBirth(input);
        return new Customer(customerID, name, phone, dateOfBirth);
    }

////hàm check id
    public String checkCustomerID(Scanner input) {
        String customerID;
        do {
            customerID = input.nextLine().trim();
            if (!customerID.matches("KH\\d{2}$")) {
                System.out.print("Nhập sai dữ liệu. ID phải có độ dài 4 ký tự và bắt đầu bằng \"KH\". Vui lòng nhập lại: ");
            } else {
                break;
            }
        } while (true);
        return customerID;
    }

//hàm check name
    public String checkName(Scanner input) {
        String name;
        do {
            name = input.nextLine().trim();
            if (name.isEmpty() || containsDigit(name)) {
                System.out.print("Nhập sai dữ liệu. Vui lòng nhập lại: ");
            } else {
                break;
            }
        } while (true);
        return name;
    }

    private boolean containsDigit(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

//hàm check phone
    public String checkPhone(Scanner input) {
        String phone;
        do {
            phone = input.nextLine().trim();
            if (!phone.matches("09\\d{8}")) {
                System.out.print("Nhập sai dữ liệu. Số điện thoại phải có độ dài 10 ký tự và bắt đầu bằng \"09\". Vui lòng nhập lại: ");
            } else {
                break;
            }
        } while (true);
        return phone;
    }

/////hàm check ngày tháng năm sinh
    public String checkDateOfBirth(Scanner input) {
        String dateOfBirth;
        do {
            dateOfBirth = input.nextLine().trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            try {
                Date date = dateFormat.parse(dateOfBirth);
                break;
            } catch (ParseException e) {
                System.out.print("Nhập sai dữ liệu. Vui lòng nhập lại theo định dạng \"dd/MM/yyyy\": ");
            }
        } while (true);
        return dateOfBirth;
    }

////hàm check tồn  tại id
    public boolean isIdExist(String id, ArrayList<Customer> customerList) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(id)) {
                return true;
            }
        }
        return false;
    }

//hàm check tồn tại phone
    public boolean isPhoneExist(String phone, ArrayList<Customer> customerList) {
        for (Customer customer : customerList) {
            if (customer.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
//hàm tìm kiếm khách hàng

    @Override
    public void execute(int choice) {

        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1:
                displayAllCustomers();
                break;
            case 2:
                searchCustomer(sc);
                break;
            case 3:
                Customer newCustomer = addKhachhang(new ArrayList<>(company.getCustomerList()));
                company.addCustomer(newCustomer);
                System.out.println("Thêm khách hàng mới thành công.");
                break;
            case 4:
                updateCustomerInfo(sc);
                break;
            case 5:
                writeCustomerDataToFile();
                break;
            case 6:
                displayAllCustomers();
                System.out.print("Nhập ID khách hàng cần xóa: ");
                String customerID = checkCustomerID(sc);
                deleteCustomerByID(customerID);
                break;
            case 7:
                System.out.println("Đã thoát chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại, chỉ nhập từ 1 -> 7");
        }

    }

    public void searchCustomer(Scanner sc) {
        String[] searchOptions = new String[]{"Tìm theo mã khách hàng", "Tìm theo tên ", "Tìm theo phone", "Tìm theo ngày sinh", "Exit"};
        Menu searchMenu = new Menu("Tìm kiếm khách hàng", searchOptions) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        searchByCusID(sc);
                        break;
                    case 2:
                        searchByName(sc);
                        break;
                    case 3:
                        searchByPhone(sc);
                        break;
                    case 4:
                        searchByDoB(sc);
                        break;
                    case 5:
                        System.out.println("Đã thoát chương trình tìm kiếm.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại, chỉ nhập từ 1 ->5");
                }
            }
        };
        searchMenu.run();
    }

    public void updateCustomerInfo(Scanner sc) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ID khách hàng cập nhật thông tin: ");
        String customerID = checkCustomerID(scanner);
        List< Customer> customerToUpdate = company.searchCondition((Customer t) -> t.getCustomerID().equals(customerID));

        if (customerToUpdate != null) {
            System.out.println("Thông tin sách cần cập nhật: ");
            System.out.println(customerToUpdate);
            String[] updateOptions = new String[]{"Cập nhật số điện thoại", "Cập nhật ngày tháng năm sinh", "Exit"};
            Menu updateCustomerMenu = new Menu("Chọn thông tin cập nhật", updateOptions) {
                @Override

                public void execute(int choice) {

                    switch (choice) {
                        case 1:
                            System.out.print("Nhập số điện thoại mới: ");
                            String newPhone = checkPhone(scanner);
                            for (Customer customer : customerToUpdate) {
                                customer.setPhone(newPhone);
                            }
                            System.out.println("Cập nhật số điện thoại thành công.");
                            break;
                        case 2:
                            System.out.print("Nhập ngày tháng năm sinh mới (dd/MM/yyyy): ");
                            String newDateOfBirth = checkDateOfBirth(scanner);
                            for (Customer customer : customerToUpdate) {
                                customer.setDateofBirth(newDateOfBirth);
                            }
                            System.out.println("Cập nhật ngày tháng năm sinh thành công.");
                            break;
                        case 3:
                            System.out.println("Thoát khỏi quá trình cập nhật.");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.Chỉ chọn 1 -> 3");
                            break;
                    }

                }
            };
            updateCustomerMenu.run();
        } else {
            System.out.println("Không có khách hàng nào");
        }
    }

    public void writeCustomerDataToFile() {
        try {
            FileWriter writer = new FileWriter("src/model/Customer1.txt");
            for (Customer customer : company.getCustomerList()) {
                writer.write(customer.getCustomerID() + ","
                        + customer.getName() + ","
                        + customer.getPhone() + ","
                        + customer.getDateofBirth() + "\n");
            }
            writer.close();
            System.out.println("Dữ liệu khách hàng đã được ghi vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file.");
        }

    }
    // Hàm xóa khách hàng theo ID

    public void deleteCustomerByID(String customerID) {
        List<Customer> customerToDelete = company.searchCondition((Customer t) -> t.getCustomerID().equals(customerID));

        Scanner scanner = new Scanner(System.in);

        while (customerToDelete.isEmpty()) {
            System.out.println("Không tìm thấy khách hàng với ID đã cho.");
            System.out.print("Vui lòng nhập lại ID khách hàng cần xóa (hoặc nhập 'n' để hủy): ");
            String input = checkCustomerID(scanner);
            if (input.equalsIgnoreCase("n")) {
                System.out.println("Hủy xóa khách hàng.");
                return;
            }
            customerToDelete = company.searchCondition((Customer t) -> t.getCustomerID().equals(input));
        }
        System.out.println("Khách hàng được tìm thấy: " + customerToDelete.toString());
        System.out.print("Bạn có chắc chắn muốn xóa khách hàng này? (y/n): ");

        String confirmation = checkToF(scanner);
        if (confirmation.equalsIgnoreCase("y")) {
            company.removeCus(customerToDelete.get(0));
            System.out.println("Xóa khách hàng thành công.");
        } else if (confirmation.equalsIgnoreCase("n")) {
            System.out.println("Hủy xóa khách hàng.");
        }
    }

    private void searchByCusID(Scanner sc) {
        System.out.println("Hãy nhập vào ID cần tìm kiếm");
        String ID = checkCustomerID(sc);
        List<Customer> searchResult = company.searchCondition((Customer t) -> t.getCustomerID().equals(ID));
        printSearchResults(searchResult);
    }

    private void searchByName(Scanner sc) {
        System.out.println("Hãy nhập vào tên khách hàng cần tìm kiếm");
        String name = checkName(sc);
        List<Customer> searchResult = company.searchCondition((Customer t) -> t.getName().contains(name));
        printSearchResults(searchResult);
    }

    private void searchByPhone(Scanner sc) {
        System.out.println("Hãy nhập vào số điện thoại cần tìm kiếm");
        String phone = checkPhone(sc);
        List<Customer> searchResult = company.searchCondition((Customer t) -> t.getPhone().equals(phone));
        printSearchResults(searchResult);
    }

    private void searchByDoB(Scanner sc) {
        System.out.println("Hãy nhập vào ngày tháng năm sinh cần tìm kiếm");
        String dOb = checkDateOfBirth(sc);
        List<Customer> searchResult = company.searchCondition((Customer t) -> t.getDateofBirth().contains(dOb));
        printSearchResults(searchResult);
    }

    private void printSearchResults(List<Customer> searchResult) {
        if (!searchResult.isEmpty()) {
            System.out.println("Tổng cộng có: " + searchResult.size() + " khách hàng");
            for (Customer cus : searchResult) {
                System.out.println(cus.toString());
            }
        } else {
            System.out.println("Không tìm ra khách hàng nào.");
        }
    }

    public String checkToF(Scanner input) {
        String checkToF;
        do {
            checkToF = input.nextLine().trim();
            if (!checkToF.matches("[yn]")) {
                System.out.print("Nhập sai dữ liệu. Phải nhập y hoặc n: ");
            } else {
                break;
            }
        } while (true);
        return checkToF;
    }

    public String checkGmail(Scanner input) {
        String email;
        do {
            email = input.nextLine().trim();
            if (!email.matches("^[a-z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$")) {
                System.out.print("Nhập sai dữ liệu. Phải nhập theo định dạng email(vd: truongdaihoc@fpt.edu.vn): ");
            } else {
                break;
            }
        } while (true);
        return email;
    }
     public boolean isValidCustomerID(String ID) {
        return ID.matches("KH\\d{2}$");
    }

    public boolean isValidName(String name) {
        if (name.isEmpty() || containsDigit(name)) {
            return false;
        }
        return true;
    }

    public boolean isValidPhone(String phone) {
        return phone.matches("09\\d{8}");
    }

    public boolean isValidDateOfBirth(String dateOfBirth) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
