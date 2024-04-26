package service.Impl;

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


public class PhoneService implements IDeviceService<Phone> {
    private static View<Phone> view = new View<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayList() {
        view.printList(IOTest.phonesRepository, "điện thoại");
    }

    @Override
    public void add() {
        System.out.println("---------- THÊM ĐIỆN THOẠI CẦM ----------");
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
        String manufacturerPhone = View.manufacturerPhone();
        System.out.print("- Xin mời nhập tên địa thoại: ");
        String namePhone = scanner.nextLine();
        String phoneNumber = Validate.checkIntInPut("^(?:\\s*|(?:032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092)\\d{7})$","- Xin mời nhập số điện thoại: ","- Số điện thoại chỉ chứa 10 chữ số, xin mời nhập lại");
        System.out.print("- Xin mời nhập mật khẩu điện thoại: ");
        String password = scanner.nextLine();
        System.out.print("- Nhập tình trạng điện thoại: ");
        String status =  scanner.nextLine();
        System.out.print("- Xin mời nhập ghi chú: ");
        String note = scanner.nextLine();
        IOTest.phonesRepository.add(new Phone(id,name,cccd,price,phoneNumber,pawnDate,note,manufacturerPhone,namePhone,password,status));
        IOTest.writePhone();
    }

    @Override
    public void edit(int idEdit) {
        Phone phone = findById(idEdit);
        System.out.println("---------- CHỈNH SỬA ĐIỆN THOẠI CẦM ----------");
        if (phone != null){
            phone.setName(Validate.checkIntInPut("^[a-zA-Z]+$","- Nhập tên: ","- Tên chỉ được chứa chữ, xin mời nhập lại: "));
            phone.setCccd(Validate.checkIntInPut("^(?:\\d{12})?$","- Nhập cccd: ","- CCCD chỉ được chứa 12 chữ số, xin mời nhập lại: "));
            phone.setPrice(Integer.parseInt(Validate.checkIntInPut("^[0-9]+$","- Nhập số tiền cầm: ","- Tiền không được chứa kí tự, xin mời nhập lại: ")));
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
            phone.setPawnDate(pawnDate);
            phone.setManufacturerPhone(View.manufacturerPhone());
            System.out.print("- Xin mời nhập tên địa thoại: ");
            phone.setNamePhone(scanner.nextLine());
            phone.setPhoneNumber(Validate.checkIntInPut("^(?:\\s*|(?:032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092)\\d{7})$","- Xin mời nhập số điện thoại: ","- Số điện thoại chỉ chứa 10 chữ số, xin mời nhập lại"));
            System.out.print("- Xin mời nhập mật khẩu điện thoại: ");
            phone.setPassword(scanner.nextLine());
            System.out.print("- Nhập tình trạng điện thoại: ");
            phone.setStatus(scanner.nextLine());
            System.out.print("- Xin mời nhập ghi chú: ");
            phone.setNote(scanner.nextLine());
            IOTest.writePhone();
        }else {
            System.out.println("- ID này không tồn tại, Không thể chỉnh sửa được");
        }
    }

    @Override
    public void delete(int delete) {
        String notification = "- ID này không tồn tại, không thể xoá";
        for (int i = 0; i < IOTest.phonesRepository.size(); i++) {
            if (IOTest.phonesRepository.get(i).getId() == delete){
                notification = "- Xoá thành công.";
                IOTest.phonesRepository.remove(i);
                IOTest.writePhone();
                break;
            }
        }
        System.out.println(notification);
    }

    @Override
    public void extend(int extend) {
        Phone phone = findById(extend);
        int days = 0;
        if (phone != null){
            days = Integer.parseInt(Validate.checkIntInPut("","",""));
            System.out.println("- Số tiền lãi " + days + " ngày là : " + money_all_days(days, phone.getPrice()));
            if (View.confirm("Bạn có muốn gia hạn không")){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(phone.getPawnDate());
                calendar.add(Calendar.DATE, days);
                Date newDate = calendar.getTime();
                phone.setPawnDate(newDate);
                IOTest.writePhone();
            }
        }else {
            System.out.println("- ID này không tồn tại, Không thể gia hạn");
        }

    }

    @Override
    public void takeTheProduct(int idToTake) {
        Phone phone = findById(idToTake);
        if (phone != null){
            long daysBetween = ChronoUnit.DAYS.between(phone.getPawnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
            System.out.println("- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + daysBetween + " ngày là : " + money_all_days((int) daysBetween,phone.getPrice()));
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
            for (Phone phone: IOTest.phonesRepository) {
                if (phone.getId() == id){
                    check = true;
                    System.out.println("- " + id + " đã tồn tại, xin hãy nhập id khác");
                    break;
                }
            }
        }
        return id;
    }

    @Override
    public Phone findById(int idToFind) {
        for (int i = 0; i < IOTest.phonesRepository.size(); i++) {
            if (IOTest.phonesRepository.get(i).getId() == idToFind){
                return IOTest.phonesRepository.get(i);
            }
        }
        return null;
    }
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
