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
import java.util.List;
import java.util.Scanner;


public class PhoneService implements IDeviceService<Phone> {
    private static View<Phone> view = new View<>();
    private static PredicateService<Phone> predicateService = new PredicateService<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayList() {
        view.printList(IOTest.phonesRepository, "Dánh sách điện thoại cầm");
    }

    @Override
    public void add() {
        System.out.println("---------- THÊM ĐIỆN THOẠI CẦM ----------");
        int id = checkIdIsExist();
        String name = Validate.checkIntInPut("^[a-zA-Z]+$", "- Nhập tên: ", "- Tên chỉ được chứa chữ, xin mời nhập lại: ");
        String cccd = Validate.checkIntInPut("^(?:\\d{12})?$", "- Nhập cccd: ", "- CCCD chỉ được chứa 12 chữ số, xin mời nhập lại: ");
        int price = Integer.parseInt(Validate.checkIntInPut("^[0-9]+$", "- Nhập số tiền cầm: ", "- Tiền không được chứa kí tự, xin mời nhập lại: "));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date pawnDate;
        try {
            String date = Validate.checkIntInPut("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$|^$", "- Mời nhập ngày theo định dạng dd/MM/yyyy: ", "- Sai định dạng rồi, xin mời nhập lại: ");
            if (date.replaceAll("\\s+", "") == "") {
                pawnDate = new Date();
            } else {
                pawnDate = dateFormat.parse(date);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String manufacturerPhone = View.manufacturerPhone();
        System.out.print("- Xin mời nhập tên địa thoại: ");
        String namePhone = scanner.nextLine();
        String phoneNumber = Validate.checkIntInPut("^(?:\\s*|(?:032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092)\\d{7})$", "- Xin mời nhập số điện thoại: ", "- Số điện thoại chỉ chứa 10 chữ số, xin mời nhập lại");
        System.out.print("- Xin mời nhập mật khẩu điện thoại: ");
        String password = scanner.nextLine();
        System.out.print("- Nhập tình trạng điện thoại: ");
        String status = scanner.nextLine();
        System.out.print("- Xin mời nhập ghi chú: ");
        String note = scanner.nextLine();
        IOTest.phonesRepository.add(new Phone(id, name, cccd, price, phoneNumber, pawnDate, note, manufacturerPhone, namePhone, password, status));
        IOTest.writePhone();
    }

    @Override
    public void edit(int idEdit) {
        int choose = 0;
        Boolean loop = true;
        Phone phone = findById(idEdit);
        if (phone != null) {
            System.out.println("---------- CHỈNH SỬA ĐIỆN THOẠI CẦM ----------");
            while (loop) {
                view.viewOptionPhone();
                choose = Integer.parseInt(Validate.checkIntInPut("^(?:[1-9]|1[0-1])$","- Nhập lựa chọn muốn chỉnh sửa: ","- Lựa chọn chỉ nhập số từ 1 - 11, xin mời nhập lại: "));
                switch (choose) {
                    case 1:
                        phone.setName(Validate.checkIntInPut("^[a-zA-Z]+$", "- Nhập tên: ", "- Tên chỉ được chứa chữ, xin mời nhập lại: "));
                        IOTest.writePhone();
                        break;
                    case 2:
                        phone.setCccd(Validate.checkIntInPut("^(?:\\d{12})?$", "- Nhập cccd: ", "- CCCD chỉ được chứa 12 chữ số, xin mời nhập lại: "));
                        IOTest.writePhone();
                        break;
                    case 3:
                        phone.setPrice(Integer.parseInt(Validate.checkIntInPut("^[0-9]+$", "- Nhập số tiền cầm: ", "- Tiền không được chứa kí tự, xin mời nhập lại: ")));
                        IOTest.writePhone();
                        break;
                    case 4:
                        phone.setPhoneNumber(Validate.checkIntInPut("^(?:\\s*|(?:032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092)\\d{7})$", "- Xin mời nhập số điện thoại: ", "- Số điện thoại chỉ chứa 10 chữ số, xin mời nhập lại"));
                        IOTest.writePhone();
                        break;
                    case 5:
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date pawnDate;
                        try {
                            String date = Validate.checkIntInPut("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$|^$", "- Mời nhập ngày theo định dạng dd/MM/yyyy: ", "- Sai định dạng rồi, xin mời nhập lại: ");
                            if (date.replaceAll("\\s+", "") == "") {
                                pawnDate = new Date();
                            } else {
                                pawnDate = dateFormat.parse(date);
                            }
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        phone.setPawnDate(pawnDate);
                        IOTest.writePhone();
                        break;
                    case 6:
                        System.out.print("- Xin mời nhập ghi chú: ");
                        phone.setNote(scanner.nextLine());
                        IOTest.writePhone();
                        break;
                    case 7:
                        phone.setManufacturerPhone(View.manufacturerPhone());
                        IOTest.writePhone();
                        break;
                    case 8:
                        System.out.print("- Xin mời nhập tên địa thoại: ");
                        phone.setNamePhone(scanner.nextLine());
                        IOTest.writePhone();
                        break;
                    case 9:
                        System.out.print("- Xin mời nhập mật khẩu điện thoại: ");
                        phone.setPassword(scanner.nextLine());
                        IOTest.writePhone();
                        break;
                    case 10:
                        System.out.print("- Nhập tình trạng điện thoại: ");
                        phone.setStatus(scanner.nextLine());
                        IOTest.writePhone();
                        break;
                    case 11:
                        loop = false;
                        break;
                }
            }
        } else {
            System.out.println("- ID này không tồn tại, Không thể chỉnh sửa được");
        }
    }

    @Override
    public void delete(int delete) {
        String notification = "- ID này không tồn tại, không thể xoá";
        for (int i = 0; i < IOTest.phonesRepository.size(); i++) {
            if (IOTest.phonesRepository.get(i).getId() == delete) {
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
        if (phone != null) {
            days = Integer.parseInt(Validate.checkIntInPut("^[0-9]+$", "- Nhập số ngày muốn gia hạn: ", "- Số ngày không được chứa ký tự, xin mời nhập lại: "));
            System.out.println("- Số tiền lãi " + days + " ngày là : " + money_all_days(days, phone.getPrice()));
            if (View.confirm("Bạn có muốn gia hạn không")) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(phone.getPawnDate());
                calendar.add(Calendar.DATE, days);
                Date newDate = calendar.getTime();
                phone.setPawnDate(newDate);
                IOTest.writePhone();
            }
        } else {
            System.out.println("- ID này không tồn tại, Không thể gia hạn");
        }

    }

    @Override
    public void takeTheProduct(int idToTake) {
        Phone phone = findById(idToTake);
        if (phone != null) {
            long daysBetween = ChronoUnit.DAYS.between(phone.getPawnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
            System.out.println("- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + Math.abs(daysBetween) + " ngày là : " + Math.abs(money_all_days((int) daysBetween, phone.getPrice())));
            if (View.confirm("Bạn có muốn lấy điện thoại cầm này không")) {
                delete(idToTake);
                IOTest.writePhone();
            }
        } else {
            System.out.println("- ID này không tồn tại, Không thể lấy máy");
        }
    }

    @Override
    public int checkIdIsExist() {
        Boolean check = true;
        int id = 0;
        while (check) {
            check = false;
            id = Integer.parseInt(Validate.checkIntInPut("^[0-9]+$", "- Nhập id: ", "- ID không được chứa kí tự, xin mời nhập lại: "));
            for (Phone phone : IOTest.phonesRepository) {
                if (phone.getId() == id) {
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
            if (IOTest.phonesRepository.get(i).getId() == idToFind) {
                return IOTest.phonesRepository.get(i);
            }
        }
        return null;
    }

    private int money_all_days(int days, int price) {
        int payment = 0;
        payment = ((price / 1000000) * 3000 + less_than_500(price)) * days;
        return payment;
    }

    private int less_than_500(int price) {
        int support = price % 1000000;
        if (support == 0) {
            return 0;
        } else if (support < 500000) {
            return 2000;
        } else {
            return 3000;
        }
    }

    @Override
    public List<Phone> findListFollowId(String id) {
        return predicateService.searchCondition((Phone phone) -> phone.stringID().contains(id), IOTest.phonesRepository);
    }

    @Override
    public List<Phone> findListFollowName(String name) {
        return predicateService.searchCondition((Phone phone) -> phone.getName().contains(name), IOTest.phonesRepository);
    }
}
