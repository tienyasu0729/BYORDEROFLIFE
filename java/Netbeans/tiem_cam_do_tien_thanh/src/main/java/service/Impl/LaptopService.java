package service.Impl;

import model.Laptop;
import model.Phone;
import repository.IOTest;
import service.IDeviceService;
import validate.Validate;
import views.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LaptopService implements IDeviceService<Laptop> {
    private static View<Laptop> view = new View<>();
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void displayList() {
        view.printList(IOTest.laptopsRepository, "máy tính");

    }

    @Override
    public void add() {
        System.out.println("---------- THÊM LAPTOP CẦM ----------");
        int id = checkIdIsExist();
        String name = Validate.checkIntInPut("^[a-zA-Z]+$","- Nhập tên: ","- Tên chỉ được chứa chữ, xin mời nhập lại: ");
        String cccd = Validate.checkIntInPut("^(?:\\d{12})?$","- Nhập cccd: ","- CCCD chỉ được chứa 12 chữ số, xin mời nhập lại: ");
        int price = Integer.parseInt(Validate.checkIntInPut("^[0-9]+$","- Nhập số tiền cầm: ","- Tiền không được chứa kí tự, xin mời nhập lại: "));
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        Date pawnDate;
        try {
            String date = Validate.checkIntInPut("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$|^$","- Mời nhập ngày theo định dạng dd/MM/yyyy: ","- Sai định dạng rồi, xin mời nhập lại: ");
            if (date.replaceAll("\\s+","") == ""){
                pawnDate = new Date();
            }else {
                pawnDate = dateFormat.parse(date);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String manufacturerLaptop = View.manufacturerLaptop();
        System.out.print("- Xin mời nhập tên địa thoại: ");
        String nameLaptop = scanner.nextLine();
        String phoneNumber = Validate.checkIntInPut("^(?:\\s*|(?:032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092)\\d{7})$","- Xin mời nhập số điện thoại: ","- Số điện thoại chỉ chứa 10 chữ số, xin mời nhập lại");
        System.out.print("- Xin mời nhập mật khẩu điện thoại: ");
        String password = scanner.nextLine();
        System.out.print("- Nhập tình trạng điện thoại: ");
        String status =  scanner.nextLine();
        System.out.print("- Xin mời nhập ghi chú: ");
        String note = scanner.nextLine();
        IOTest.laptopsRepository.add(new Laptop(id,name,cccd,price,phoneNumber,pawnDate,note,manufacturerLaptop,nameLaptop,password,status));
        IOTest.writeLaptop();
    }

    @Override
    public void edit(int idEdit) {
        System.out.println("---------- CHỈNH SỬA LAPTOP CẦM ----------");
        Laptop laptop = findById(idEdit);
        if (laptop != null){
            laptop.setName(Validate.checkIntInPut("^[a-zA-Z]+$","- Nhập tên: ","- Tên chỉ được chứa chữ, xin mời nhập lại: "));
            laptop.setCccd(Validate.checkIntInPut("^(?:\\d{12})?$","- Nhập cccd: ","- CCCD chỉ được chứa 12 chữ số, xin mời nhập lại: "));
            laptop.setPrice(Integer.parseInt(Validate.checkIntInPut("^[0-9]+$","- Nhập số tiền cầm: ","- Tiền không được chứa kí tự, xin mời nhập lại: ")));
            SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
            Date pawnDate;
            try {
                String date = Validate.checkIntInPut("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$|^$","- Mời nhập ngày theo định dạng dd/MM/yyyy: ","- Sai định dạng rồi, xin mời nhập lại: ");
                if (date.replaceAll("\\s+","") == ""){
                    pawnDate = new Date();
                }else {
                    pawnDate = dateFormat.parse(date);
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            laptop.setPawnDate(pawnDate);
            laptop.setManufacturerLaptop(View.manufacturerLaptop());
            System.out.print("- Xin mời nhập tên địa thoại: ");
            laptop.setNameLaptop(scanner.nextLine());
            laptop.setPhoneNumber( Validate.checkIntInPut("^(?:\\s*|(?:032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092)\\d{7})$","- Xin mời nhập số điện thoại: ","- Số điện thoại chỉ chứa 10 chữ số, xin mời nhập lại"));
            System.out.print("- Xin mời nhập mật khẩu điện thoại: ");
            laptop.setPassword(scanner.nextLine());
            System.out.print("- Nhập tình trạng điện thoại: ");
            laptop.setStatus(scanner.nextLine());
            System.out.print("- Xin mời nhập ghi chú: ");
            laptop.setNote(scanner.nextLine());
            IOTest.writeLaptop();
        }else {
            System.out.println("- ID này không tồn tại, Không thể chỉnh sửa được");
        }
    }

    @Override
    public void delete(int idDelete) {
        String notification = "- ID này không tồn tại, không thể xoá";
        for (int i = 0; i < IOTest.laptopsRepository.size(); i++) {
            if (IOTest.laptopsRepository.get(i).getId() == idDelete){
                notification = "- Xoá thành công.";
                IOTest.laptopsRepository.remove(i);
                IOTest.writeLaptop();
                break;
            }
        }
        System.out.println(notification);
    }

    @Override
    public void extend(int idExtend) {
        Laptop laptop = findById(idExtend);
        int days = 0;
        if (laptop != null){
            days = Integer.parseInt(Validate.checkIntInPut("","",""));
            System.out.println("- Số tiền lãi " + days + " ngày là : " + money_all_days(days, laptop.getPrice()));
            if (View.confirm("Bạn có muốn gia hạn không")){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(laptop.getPawnDate());
                calendar.add(Calendar.DATE, days);
                Date newDate = calendar.getTime();
                laptop.setPawnDate(newDate);
                IOTest.writeLaptop();
            }
        }else {
            System.out.println("- ID này không tồn tại, Không thể gia hạn");
        }

    }

    @Override
    public void takeTheProduct(int idToTake) {
        Laptop laptop = findById(idToTake);
        if (laptop != null){
            long daysBetween = ChronoUnit.DAYS.between(laptop.getPawnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
            System.out.println("- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + daysBetween + " ngày là : " + money_all_days((int) daysBetween,laptop.getPrice()));
            if (View.confirm("Bạn có muốn lấy điện thoại cầm này không")){
                delete(idToTake);
                IOTest.writePhone();
            }
        }else {
            System.out.println("- ID này không tồn tại, Không thể lấy máy");
        }
    }

    @Override
    public int checkIdIsExist() {
        Boolean check = true;
        int id = 0;
        while (check){
            check = false;
            id = Integer.parseInt(Validate.checkIntInPut("^[0-9]+$","- Nhập id: ","- ID không được chứa kí tự, xin mời nhập lại: "));
            for (Laptop laptop: IOTest.laptopsRepository) {
                if (laptop.getId() == id){
                    check = true;
                    System.out.println("- " + id + " đã tồn tại, xin hãy nhập id khác");
                    break;
                }
            }
        }
        return id;
    }

    @Override
    public Laptop findById(int idToFind) {
        for (int i = 0; i < IOTest.laptopsRepository.size(); i++) {
            if (IOTest.laptopsRepository.get(i).getId() == idToFind){
                return IOTest.laptopsRepository.get(i);
            }
        }
        return null;    }
    private int money_all_days(int days, int price){
        int payment = 0;
        payment = ((price / 1000000) * 3000 + less_than_500(price)) * days;
        return payment;
    }
    private int less_than_500 (int price){
        int support = price % 1000000;
        if ( support == 0){
            return 0;
        }else if (support < 500000){
            return 2000;
        }else {
            return 3000;
        }
    }
}
