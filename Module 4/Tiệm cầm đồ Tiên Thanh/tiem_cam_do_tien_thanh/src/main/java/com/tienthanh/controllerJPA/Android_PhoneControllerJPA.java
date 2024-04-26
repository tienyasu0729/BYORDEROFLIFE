    package com.tienthanh.controllerJPA;

    import com.tienthanh.modelJPA.Android_PhoneJPA;
    import com.tienthanh.modelORM.Android_PhoneORM;
    import com.tienthanh.serviceJPA.IAndroid_PhoneServiceJPA;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.text.SimpleDateFormat;
    import java.time.LocalDate;
    import java.time.ZoneId;
    import java.time.temporal.ChronoUnit;
    import java.util.Calendar;
    import java.util.Date;


    @Controller
    @RequestMapping("tienthanhJPA")
    public class Android_PhoneControllerJPA {
        @Autowired
        private IAndroid_PhoneServiceJPA androidPhoneServiceJPA;

//        @ModelAttribute("default")
//        public String defaultvalue(){
//            return "Không có";
//        }

        @GetMapping("")
        public String listAndroid_Phone(Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceJPA.displayAndroid_Phone());
            model.addAttribute("android_phone", new Android_PhoneJPA());
            return "listAndroid_PhoneJPA";
        }
        @PostMapping("add_or_edit_new_android_phone")
        public String add_or_edit_new_android_phone(@ModelAttribute Android_PhoneJPA androidPhoneJPA){
            androidPhoneServiceJPA.add_or_edit_new_android_phone(androidPhoneJPA);
            return "redirect:/tienthanhJPA/";
        }

        // có anotation @ResponeBody là ajax
        @PostMapping("check_if_id_exist")
        @ResponseBody
        public String check_if_id_exist(@RequestParam("id_need_to_check") String id){
            return androidPhoneServiceJPA.check_if_id_exist(id).toString();
        }

        @PostMapping("delete_android_phone_by_id")
        @ResponseBody
        public String delete_android_phone_by_id(@RequestParam("id_need_to_delete") String idToDelete){
            return androidPhoneServiceJPA.delete_Android_Phone(idToDelete).toString();
        }

        @PostMapping("list_Find_Android_Phone_Similar_By_Id")
        public String list_Find_Android_Phone_Similar_By_Id(@RequestParam("find_by_id") String id, Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceJPA.list_Find_Android_Phone_Similar_By_Id(id));
            model.addAttribute("android_phone", new Android_PhoneJPA());
            return "listAndroid_PhoneJPA";

        }

        @PostMapping("list_Find_Android_Phone_Similar_By_Name")
        public String list_Find_Android_Phone_Similar_By_Name(@RequestParam("find_by_name") String name, Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceJPA.list_Find_Android_Phone_Similar_By_Name(name));
            model.addAttribute("android_phone", new Android_PhoneJPA());
            return "listAndroid_PhoneJPA";
        }

        @GetMapping("/late_list_android_phone")
        public String late_list_android_phone(Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceJPA.late_list_android_phone());
            model.addAttribute("android_phone", new Android_PhoneJPA());
            return "listAndroid_PhoneJPA";
        }
        @GetMapping("/near_term_list_android_phone")
        public String near_term_list_android_phone(Model model){
            model.addAttribute("listAndroid_Phone", androidPhoneServiceJPA.late_list_android_phone());
            model.addAttribute("android_phone", new Android_PhoneJPA());
            return "listAndroid_PhoneJPA";
        }

        @PostMapping(value = "interestPayment", produces = "text/plain;charset=UTF-8")
        @ResponseBody
        public String interestPayment(@RequestParam("start_date_interest_payment") String start_date,
                                      @RequestParam("price_interest_payment") int price,
                                      @RequestParam("days_interest_payment") int days){
            String result = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            try {
                Date startDate = dateFormat.parse(start_date);
                long daysBetween = ChronoUnit.DAYS.between(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());

                result = "- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + days + " ngày là : " + money_all_days(days,price);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(start_date);
            return result;
        }

        @PostMapping(value = "extendInterestPayment", produces = "text/plain;charset=UTF-8")
        @ResponseBody
        public String extend_interest_payment(@RequestParam("id_extend_interest_payment") String id,
                                              @RequestParam("start_date_extend_interest_payment") String start_date,
                                              @RequestParam("days_extend_interest_payment") int days){
            String result = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            try {
                Date startDate = dateFormat.parse(start_date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);
                calendar.add(Calendar.DATE, days);
                Date newDate = calendar.getTime();
                if(androidPhoneServiceJPA.extend_interest_payment(id, newDate)){// sửa ngày sau khi gia hạn trong mySQL
                    result = "- Gia hạn thành công";
                }else {
                    result = "- Gia hạn Không thành công";
                }
            } catch (Exception e) {
                result = "- Gia hạn Không thành công";
            }
            return result;
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

        @PostMapping(value = "take_the_product", produces = "text/plain;charset=UTF-8")
        @ResponseBody
        public String take_the_product(@RequestParam("start_date_take_the_product") String start_date,
                                       @RequestParam("price_take_the_product") int price){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            try {
                Date startDate = dateFormat.parse(start_date);
                long daysBetween = ChronoUnit.DAYS.between(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
                String result = "- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + daysBetween + " ngày là : " + money_all_days((int) daysBetween,price);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "Lỗi, không thể tính đuợc";
        }
    }
