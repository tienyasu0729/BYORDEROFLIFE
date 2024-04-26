package service.Impl;

import model.Laptop;
import model.Phone;
import model.Vehicle;
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

public class VehicleService implements IDeviceService<Vehicle> {
    private static View<Vehicle> view = new View<>();
    private static PredicateService<Vehicle> predicateService = new PredicateService<>();
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void displayList() {
        view.printList(IOTest.vehiclesRepository, "Danh sách xe cầm");

    }

    @Override
    public void add() {
        System.out.println("---------- THÊM XE CẦM ----------");
        int id = checkIdIsExist();
        String name = Validate.checkIntInPut("^[a-zA-Z]+$","- Nhập tên: ","- Tên chỉ được chứa chữ, xin mời nhập lại: ");
        String cccd = Validate.checkIntInPut("^\\d{12}$","- Nhập cccd: ","- CCCD chỉ được chứa 12 chữ số, xin mời nhập lại: ");
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
        String manufacturerVehicle = View.manufacturerVehicle();
        System.out.print("- Xin mời nhập tên xe: ");
        String nameVehicle = scanner.nextLine();
        String phoneNumber = Validate.checkIntInPut("^(?:\\s*|(?:032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092)\\d{7})$","- Xin mời nhập số điện thoại: ","- Số điện thoại chỉ chứa 10 chữ số, xin mời nhập lại");
        String licensePlate = Validate.checkIntInPut("^.+$","- Xin mời nhập biển số xe: ","- Biển số xe không được để rỗng, xin mời nhập lại: ");
        System.out.print("- Nhập tình trạng xe: ");
        String status =  scanner.nextLine();
        System.out.print("- Xin mời nhập ghi chú: ");
        String note = scanner.nextLine();
        IOTest.vehiclesRepository.add(new Vehicle(id,name,cccd,price,phoneNumber,pawnDate,note,manufacturerVehicle,nameVehicle,licensePlate,status));
        IOTest.writeVehicle();
    }

    @Override
    public void edit(int idEdit) {
        Boolean loop = true;
        Vehicle vehicle = findById(idEdit);
        if (vehicle != null){
            System.out.println("---------- CHỈNH SỬA XE CẦM ----------");
            while (loop){
                view.viewOptionVehicle();
                int choose = Integer.parseInt(Validate.checkIntInPut("^(?:[1-9]|1[0-1])$","- Nhập lựa chọn muốn chỉnh sửa: ","- Lựa chọn chỉ nhập số từ 1 - 11, xin mời nhập lại: "));
                switch (choose){
                    case 1:
                        vehicle.setName(Validate.checkIntInPut("^[a-zA-Z]+$","- Nhập tên: ","- Tên chỉ được chứa chữ, xin mời nhập lại: "));
                        IOTest.writeVehicle();
                        break;
                    case 2:
                        vehicle.setCccd(Validate.checkIntInPut("^\\d{12}$","- Nhập cccd: ","- CCCD chỉ được chứa 12 chữ số, xin mời nhập lại: "));
                        IOTest.writeVehicle();
                        break;
                    case 3:
                        vehicle.setPrice(Integer.parseInt(Validate.checkIntInPut("^[0-9]+$","- Nhập số tiền cầm: ","- Tiền không được chứa kí tự, xin mời nhập lại: ")));
                        IOTest.writeVehicle();
                        break;
                    case 4:
                        vehicle.setPhoneNumber(Validate.checkIntInPut("^(?:\\s*|(?:032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092)\\d{7})$","- Xin mời nhập số điện thoại: ","- Số điện thoại chỉ chứa 10 chữ số, xin mời nhập lại"));
                        IOTest.writeVehicle();
                        break;
                    case 5:
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
                        vehicle.setPawnDate(pawnDate);
                        IOTest.writeVehicle();
                        break;
                    case 6:
                        System.out.print("- Xin mời nhập ghi chú: ");
                        vehicle.setNote(scanner.nextLine());
                        IOTest.writeVehicle();
                        break;
                    case 7:
                        vehicle.setManufacturerVehicle(View.manufacturerVehicle());
                        IOTest.writeVehicle();
                        break;
                    case 8:
                        System.out.print("- Xin mời nhập tên xe: ");
                        vehicle.setNameVehicle(scanner.nextLine());
                        IOTest.writeVehicle();
                        break;
                    case 9:
                        vehicle.setLicensePlate(Validate.checkIntInPut("^.+$","- Xin mời nhập biển số xe: ","- Biển số xe không được để rỗng, xin mời nhập lại: "));
                        IOTest.writeVehicle();
                        break;
                    case 10:
                        System.out.print("- Nhập tình trạng xe: ");
                        vehicle.setStatusVehicle(scanner.nextLine());
                        IOTest.writeVehicle();
                        break;
                    case 11:
                        loop = false;
                        break;
                }
            }
        }else {
            System.out.println("- ID này không tồn tại, Không thể chỉnh sửa được");
        }
    }

    @Override
    public void delete(int idDelete) {
        String notification = "- ID này không tồn tại, không thể xoá";
        for (int i = 0; i < IOTest.vehiclesRepository.size(); i++) {
            if (IOTest.vehiclesRepository.get(i).getId() == idDelete){
                notification = "- Xoá thành công.";
                IOTest.vehiclesRepository.remove(i);
                IOTest.writeVehicle();
                break;
            }
        }
        System.out.println(notification);
    }

    @Override
    public void extend(int idExtend) {
        Vehicle vehicle = findById(idExtend);
        int days = 0;
        if (vehicle != null){
            days = Integer.parseInt(Validate.checkIntInPut("^[0-9]+$", "- Nhập số ngày muốn gia hạn: ", "- Số ngày không được chứa ký tự, xin mời nhập lại: "));
            System.out.println("- Số tiền lãi " + days + " ngày là : " + money_all_days(days, vehicle.getPrice()));
            if (View.confirm("Bạn có muốn gia hạn không")){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(vehicle.getPawnDate());
                calendar.add(Calendar.DATE, days);
                Date newDate = calendar.getTime();
                vehicle.setPawnDate(newDate);
                IOTest.writeVehicle();
            }
        }else {
            System.out.println("- ID này không tồn tại, Không thể gia hạn");
        }

    }

    @Override
    public void takeTheProduct(int idToTake) {
        Vehicle vehicle = findById(idToTake);
        if (vehicle != null){
            long daysBetween = ChronoUnit.DAYS.between(vehicle.getPawnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
            System.out.println("- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + Math.abs(daysBetween) + " ngày là : " + Math.abs(money_all_days((int) daysBetween,vehicle.getPrice())));
            if (View.confirm("Bạn có muốn lấy điện thoại cầm này không")){
                delete(idToTake);
                IOTest.writeVehicle();
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
            for (Vehicle vehicle: IOTest.vehiclesRepository) {
                if (vehicle.getId() == id){
                    check = true;
                    System.out.println("- " + id + " đã tồn tại, xin hãy nhập id khác");
                    break;
                }
            }
        }
        return id;
    }

    @Override
    public Vehicle findById(int idToFind) {
        for (int i = 0; i < IOTest.vehiclesRepository.size(); i++) {
            if (IOTest.vehiclesRepository.get(i).getId() == idToFind){
                return IOTest.vehiclesRepository.get(i);
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

    @Override
    public List<Vehicle> findListFollowId(String id) {
        return predicateService.searchCondition((Vehicle vehicle) -> vehicle.stringID().contains(id), IOTest.vehiclesRepository);

    }

    @Override
    public List<Vehicle> findListFollowName(String name) {
        return predicateService.searchCondition((Vehicle vehicle) -> vehicle.stringID().contains(name), IOTest.vehiclesRepository);
    }
}
